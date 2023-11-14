package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.Exception.HotelNotFoundException;
import com.pbl6.hotelbookingapp.Exception.ResponseException;

import com.pbl6.hotelbookingapp.Exception.UserNotFoundException;
import com.pbl6.hotelbookingapp.dto.*;
import com.pbl6.hotelbookingapp.entity.*;
import com.pbl6.hotelbookingapp.repository.*;
import jakarta.persistence.EntityManager;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class HotelService {
    private HotelRepository hotelRepository;
    private UserRepository userRepository;
    private HotelAmenityRepository amenityRepository;
    private HotelImageRepository imageRepository;
    private HotelRateRepository rateRepository;

    private HotelHotelAmenityRepository hotelHotelAmenityRepository;
    private RoomTypeRepository roomTypeRepository;
    private ReviewRepository reviewRepository;
    private ExtraServiceRepository extraServiceRepository;
    private EntityManager entityManager;


    public HotelService(HotelRepository hotelRepository, UserRepository userRepository, HotelAmenityRepository amenityRepository, HotelImageRepository imageRepository, HotelRateRepository rateRepository, HotelHotelAmenityRepository hotelHotelAmenityRepository, RoomTypeRepository roomTypeRepository, ReviewRepository reviewRepository, ExtraServiceRepository extraServiceRepository, EntityManager entityManager) {
        this.hotelRepository = hotelRepository;
        this.userRepository = userRepository;
        this.amenityRepository = amenityRepository;
        this.imageRepository = imageRepository;
        this.rateRepository = rateRepository;
        this.hotelHotelAmenityRepository = hotelHotelAmenityRepository;
        this.roomTypeRepository = roomTypeRepository;
        this.reviewRepository = reviewRepository;
        this.extraServiceRepository = extraServiceRepository;
        this.entityManager = entityManager;
    }

    public Optional<Hotel> findHotelByNameAndProvinceAndStreet(String hotelName, String province, String street) {
        return hotelRepository.findFirstByNameAndProvinceAndStreet(hotelName, province, street);
    }
    public Optional<Hotel> findHotelById(Integer id) {
        return hotelRepository.findFirstById(id);
    }

    public Set<HotelWithTopRating> getTop4HotelsWithFirstImage() {
        return hotelRepository.getTop4HotelsWithFirstImage();
    }

    public CustomSearchResult searchHotels(SearchRequest request) {

        CustomSearchResult result = new CustomSearchResult();
        if (request.getCheckoutDay()!= null && request.getCheckinDay()!=null && request.getCheckinDay().compareTo(request.getCheckoutDay()) >= 0) {
            throw new ResponseException("Check-in date cannot be greater than or equal to check-out date! ");
        }

        List<HotelSearchResult> hotels = hotelRepository.searchHotels(request.getProvince(), request.getCheckinDay(), request.getCheckoutDay(), request.getCount(), request.getAdultCount(), request.getChildrenCount());

        List<HotelFilterSearchResult> filteredHotels = new ArrayList<>();
        if(hotels.isEmpty() || hotels == null)
        {
            Long totalItems = 0L;
            result.setHotels(null);
            result.setLocation(null);
            result.setTotalItems(totalItems);
        }
        else {
            for (HotelSearchResult hotel : hotels) {
                HotelFilterSearchResult filteredHotel = new HotelFilterSearchResult();
                filteredHotel.setId(hotel.getHotelId());
                filteredHotel.setHotelName(hotel.getHotelName());
                filteredHotel.setAddress(hotel.getAddress());
                filteredHotel.setHotelImgPath(hotel.getHotelImgPath());

                Set<String> amenities = hotel.getAmenitiesSet();
                filteredHotel.setAmenities(amenities);
                filteredHotel.setMinPrice(hotel.getMinPrice());
                filteredHotel.setMaxPrice(hotel.getMaxPrice());
                filteredHotel.setReviews(hotel.getReviews());
                filteredHotel.setRating(hotel.getRatingTotal());

                filteredHotels.add(filteredHotel);
            }
            Optional<Hotel> tempHotel = hotelRepository.findFirstById(hotels.get(0).getHotelId());
            Long totalItems = (long) filteredHotels.size();
            result.setHotels(filteredHotels);
            result.setLocation(tempHotel.get().getProvince());
            result.setTotalItems(totalItems);

        }
        return result;

    }


    public AddHotelResponse addHotel(AddHotelRequest addHotelRequest, Integer userId) throws IOException {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        Hotel hotel = createHotelFromRequest(addHotelRequest, user);

        hotelRepository.save(hotel);
        Set<HotelHotelAmenity> amenities = addOrUpdateHotelAmenities(hotel, addHotelRequest.getAmenities());
        hotel.setHotelHotelAmenities(amenities);
        hotelRepository.save(hotel);

        saveHotelImages(hotel, addHotelRequest.getImages());

        AddHotelResponse responseDTO = new AddHotelResponse();
        responseDTO.setMessage("Hotel added successfully");
        return responseDTO;
    }

    private Hotel createHotelFromRequest(AddHotelRequest addHotelRequest, User user) {
        Hotel hotel = new Hotel();
        hotel.setUser(user);
        hotel.setName(addHotelRequest.getName());
        hotel.setDescription(addHotelRequest.getDescription());
        hotel.setProvince(addHotelRequest.getProvince());
        hotel.setDistrict(addHotelRequest.getDistrict());
        hotel.setMainPhoneNumber(addHotelRequest.getMainPhoneNumber());
        hotel.setMainEmail(addHotelRequest.getMainEmail());
        hotel.setStatus(addHotelRequest.getStatus());
        hotel.setWard(addHotelRequest.getWard());
        hotel.setStreet(addHotelRequest.getStreet());
        hotel.setCheckInTime(addHotelRequest.getCheckInTime());
        hotel.setCheckOutTime(addHotelRequest.getCheckOutTime());

        for (String rule : addHotelRequest.getRules()) {
            hotel.setRule(rule);
        }

        HotelRate rate = rateRepository.findById(addHotelRequest.getRate()).orElse(null);
        hotel.setHotelRate(rate);
        rateRepository.save(rate);

        return hotel;
    }

    private Set<HotelHotelAmenity> addOrUpdateHotelAmenities(Hotel hotel, List<AmenityPriceDTO> amenityPrices) {
        Set<HotelHotelAmenity> amenities = new HashSet<>();
        for (AmenityPriceDTO amenityPrice : amenityPrices) {
            HotelAmenity amenity = amenityRepository.findByName(amenityPrice.getName())
                    .orElseGet(() -> {
                        HotelAmenity newAmenity = new HotelAmenity();
                        newAmenity.setName(amenityPrice.getName());
                        return amenityRepository.save(newAmenity);
                    });
            HotelHotelAmenity hotelAmenity = new HotelHotelAmenity();
            hotelAmenity.setHotel(hotel);
            hotelAmenity.setHotelAmenity(amenity);
            hotelAmenity.setPrice(amenityPrice.getPrice());
            amenities.add(hotelAmenity);
        }
        hotelHotelAmenityRepository.saveAll(amenities);
        return amenities;
    }

    private void saveHotelImages(Hotel hotel, List<MultipartFile> images) throws IOException {
        List<String> imagePaths = saveImages(images);
        for (String imagePath : imagePaths) {
            HotelImage image = new HotelImage();
            image.setHotel(hotel);
            image.setImagePath(imagePath);
            imageRepository.save(image);
        }
    }

    public List<String> saveImages(List<MultipartFile> images) throws IOException {
        List<String> imagePaths = new ArrayList<>();
        String currentDirectory = new File("").getAbsolutePath();
        String staticPath = currentDirectory + "/src/main/resources/static";
        String uploadDir = staticPath + File.separator + "images/hotel";

        File uploadDirFile = new File(uploadDir);
        if (!uploadDirFile.exists()) {
            uploadDirFile.mkdirs();
        }
        for (MultipartFile image : images) {
            String imagePath = uploadDir + File.separator + image.getOriginalFilename();
            image.transferTo(new File(imagePath));
            imagePaths.add(imagePath);
        }
        return imagePaths;
    }



    public CustomSearchResult filterSearchHotel(FilterSearchRequest request) {
        CustomSearchResult result = new CustomSearchResult();
        SearchRequest search = new SearchRequest();
        search.setProvince(request.getProvince());
        search.setCheckinDay(request.getCheckinDay());
        search.setCheckoutDay(request.getCheckoutDay());
        search.setCount(request.getCount());
        search.setAdultCount(request.getAdultCount());
        search.setChildrenCount(request.getChildrenCount());
        CustomSearchResult firstSearch = searchHotels(search);
        int pageIndex = request.getPageIndex();
        int pageSize = request.getPageSize();

        if(request.getCount() == 0 && request.getProvince() == null && request.getCheckinDay() == null && request.getCheckoutDay() == null && request.getChildrenCount()==0 && request.getAdultCount() == 0){

            Specification<Hotel> spec = HotelSpecifications.withSmallFilters( request);
            handleSearchResult(result, pageIndex, pageSize, spec);

        }else {
            Specification<Hotel> spec = HotelSpecifications.withFilters(firstSearch, request);
            handleSearchResult(result, pageIndex, pageSize, spec);

        }
        result.setPageIndex(pageIndex);
        result.setPageSize(pageSize);

        return result;
    }

    private void handleSearchResult(CustomSearchResult result, int pageIndex, int pageSize, Specification<Hotel> spec) {
        List<Hotel> hotels = hotelRepository.findAll(spec);
        int pageTotal = calculatePageTotal(hotels.size(),pageSize);
        if(hotels.isEmpty())
        {
            throw new ResponseException("No hotel found!");
        }
        if(pageTotal-1 < pageIndex)
        {
            throw new ResponseException("Page index out of bound!");
        }
        List<HotelFilterSearchResult> searchResults = hotels.stream()
                .map(HotelFilterSearchResult::fromHotel)
                .collect(Collectors.toList());
        List<HotelFilterSearchResult> filteredHotels = getFilteredHotels(searchResults, pageIndex, pageSize);
        if(!hotels.isEmpty())
        {
            result.setLocation(hotels.get(0).getProvince());
        }
        result.setHotels(filteredHotels);
        result.setTotalItems((long) filteredHotels.size());
        result.setPageTotal(calculatePageTotal(searchResults.size(), pageSize));
    }

    private int calculatePageTotal(long totalItems, int pageSize) {
        return (int) Math.ceil((double) totalItems / pageSize);
    }
    private List<HotelFilterSearchResult> getFilteredHotels(List<HotelFilterSearchResult> allHotels, int pageIndex, int pageSize) {

        int start = pageIndex * pageSize;
        int end = Math.min(start + pageSize, allHotels.size());

        return allHotels.subList(start, end);
    }


    public HotelDetails getHotelDetails(Integer hotelId) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);

        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();

            return HotelDetails.builder()
                    .id(hotel.getId())
                    .hotelName(hotel.getName())
                    .address(buildAddress(hotel.getProvince(), hotel.getDistrict(), hotel.getWard(), hotel.getStreet()))
                    .minPrice(getMinPriceByHotelId(hotel))
                    .checkIn(hotel.getCheckInTime())
                    .checkOut(hotel.getCheckOutTime())
                    .description(hotel.getDescription())
                    .hotelImages(getHotelImagePaths(hotel.getId()))
                    .hotelAmenities(getAmenityNamesByHotelId(hotel.getId()))
                    .extraServices(getExtraAmenitiesByHotelId(hotel.getId()))
                    .roomList(getRoomTypeDetails(hotel.getRoomTypes().stream().toList()))
                    .reviews(getReviews(hotel.getReviews().stream().toList()))
                    .rules(getRules(hotel))
                    .build();
        } else {
            throw new ResponseException("Hotel not found with id: " + hotelId);
        }
    }

    private Double getMinPriceByHotelId(Hotel hotel) {
        Optional<Double> minPrice = roomTypeRepository.findMinPriceByHotelId(hotel.getId());
        return minPrice.orElse(0.0);

    }

    private List<RoomTypeDetails> getRoomTypeDetails(List<RoomType> roomList) {
        return Optional.ofNullable(roomList)
                .orElse(List.of())
                .stream()
                .map(room -> {

                    return RoomTypeDetails.builder()
                        .id(room.getId())
                        .roomName(room.getName())
                        .price(room.getPrice())
                        .roomImage(getFirstImageByRoom(room.getId()))
                        .quantity(room.getCount())
                        .adult(room.getAdultCount())
                        .children(room.getChildrenCount())
                        .roomAmenities(getListAmenities(room))
                        .build();
                })
                .collect(Collectors.toList());
    }
    private String buildAddress(String province,String district, String ward, String street) {

        return province +", " + district + ", " + ward + ", " + street;
    }
    private List<String> getListAmenities(RoomType room) {
        return roomTypeRepository.findAmenitiesByRoomTypeId(room.getId());
    }
    private String getFirstImageByRoom(Integer roomId) {
        return roomTypeRepository.findFirstImageByRoomTypeId(roomId);

    }
    private List<ReviewDTO> getReviews(List<Review> reviews) {
        return reviews.stream()
                .map(review -> ReviewDTO.builder()
                        .id(review.getId())
                        .rate(review.getRatingTotal())
                        .review(review.getComment())
                        .build())
                .collect(Collectors.toList());
    }

    private List<String> getRules(Hotel hotel) {
        return Arrays.asList(hotel.getRule().split("\\s*,\\s*"));
    }
    public List<String> getHotelImagePaths(Integer hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + hotelId));

        return hotel.getHotelImages().stream()
                .map(HotelImage::getImagePath)
                .collect(Collectors.toList());
    }
    public List<String> getAmenityNamesByHotelId(Integer hotelId) {
        Hotel hotel = new Hotel();
        hotel.setId(hotelId);

        List<HotelHotelAmenity> hotelHotelAmenities = hotelHotelAmenityRepository.findByHotel(hotel);

        return hotelHotelAmenities.stream()
                .map(hotelHotelAmenity -> hotelHotelAmenity.getHotelAmenity().getName())
                .collect(Collectors.toList());
    }
    public List<ExtraService> getExtraAmenitiesByHotelId(Integer hotelId) {
        return extraServiceRepository.findByHotelId(hotelId);
    }
}



