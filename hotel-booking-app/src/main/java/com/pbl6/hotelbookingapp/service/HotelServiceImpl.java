package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.Exception.HotelNotFoundException;
import com.pbl6.hotelbookingapp.Exception.ResponseException;

import com.pbl6.hotelbookingapp.Exception.UserNotFoundException;
import com.pbl6.hotelbookingapp.dto.*;
import com.pbl6.hotelbookingapp.entity.*;
import com.pbl6.hotelbookingapp.repository.*;
import jakarta.persistence.EntityManager;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final UserRepository userRepository;
    private final HotelAmenityRepository amenityRepository;
    private final HotelImageRepository imageRepository;
    private final HotelRateRepository rateRepository;
    private final HotelHotelAmenityRepository hotelHotelAmenityRepository;
    private final RoomTypeRepository roomTypeRepository;
    private final ReviewRepository reviewRepository;
    private final ExtraServiceRepository extraServiceRepository;
    private final EntityManager entityManager;
    private final RoomService roomService;

    private final FirebaseStorageService firebaseStorageService;



    @Override
    public Optional<Hotel> findHotelByNameAndProvinceAndStreet(String hotelName, String province, String street) {
        return hotelRepository.findFirstByNameAndProvinceAndStreet(hotelName, province, street);
    }
    @Override
    public Optional<Hotel> findHotelById(Integer id) {
        return hotelRepository.findFirstById(id);
    }

    @Override
    public Set<HotelWithTopRating> getTop4HotelsWithFirstImage() {
        return hotelRepository.getTop4HotelsWithFirstImage();
    }

    @Override
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

    @Override
    @Transactional
    public AddHotelResponse addHotel(Integer userId, HotelDTO request) throws IOException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        user.setRole(Role.HOST);
        userRepository.save(user);
        Hotel newHotel = new Hotel();
        newHotel.setUser(user);
        updateHotel(newHotel, request);
        hotelRepository.save(newHotel);
        updateHotelAmenities(newHotel, request.getAmenities());
        updateExtraAmenities(newHotel, request.getExtraServices());
        updateHotelImages(newHotel, request.getImages());
        return new AddHotelResponse(newHotel.getId());
    }

    @Override
    @Transactional
    public void updateHotel(Integer userId, Integer hotelId, HotelDTO request) throws IOException {
        Hotel hotel = hotelRepository.findByIdAndUserId(hotelId, userId)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found for the given user"));
        updateHotel(hotel, request);
        hotelRepository.save(hotel);
        updateHotelAmenities(hotel, request.getAmenities());
        updateExtraAmenities(hotel, request.getExtraServices());
        updateHotelImages(hotel, request.getImages());
    }


    @Override
    @Transactional
    public void deleteHotelById(Integer userId, Integer hotelId) {
        Hotel hotel = hotelRepository.findByUserIdAndId(userId, hotelId)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        hotelHotelAmenityRepository.deleteByHotelId(hotelId);
        deleteOrphanedHotelAmenities();
        hotelRepository.delete(hotel);
    }

    @Override
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
        if(request.getPageIndex() == 0 || request.getPageSize() == 0)
        {
            handleSearchRequest(request, result, firstSearch,0,6);
        }
        else {

            int pageIndex = request.getPageIndex()-1;
            int pageSize = request.getPageSize();

            handleSearchRequest(request, result, firstSearch,pageIndex,pageSize);
        }

        return result;
    }


    @Override
    public HotelDetails getHotelDetails(HotelDetailsRequest request) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(request.getHotelId());

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
                    .roomList(getRoomTypeDetails(hotel.getRoomTypes().stream().toList(), request.getCheckInDay(), request.getCheckOutDay()))
                    .reviews(getReviews(hotel.getReviews().stream().toList()))
                    .rules(getRules(hotel))
                    .status(hotel.getStatus())
                    .build();
        } else {
            throw new ResponseException("Hotel not found with id: " + request.getHotelId());
        }
    }

    @Override
    public List<String> getHotelImagePaths(Integer hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + hotelId));

        return hotel.getHotelImages().stream()
                .map(HotelImage::getImagePath)
                .collect(Collectors.toList());
    }
    @Override
    public List<String> getAmenityNamesByHotelId(Integer hotelId) {
        Hotel hotel = new Hotel();
        hotel.setId(hotelId);

        List<HotelHotelAmenity> hotelHotelAmenities = hotelHotelAmenityRepository.findByHotel(hotel);

        return hotelHotelAmenities.stream()
                .map(hotelHotelAmenity -> hotelHotelAmenity.getHotelAmenity().getName())
                .collect(Collectors.toList());
    }
    @Override
    public List<ExtraService> getExtraAmenitiesByHotelId(Integer hotelId) {
        return extraServiceRepository.findByHotelId(hotelId);
    }

    @Override
    public Hotel getHotelById(Integer hotelId) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
        if (optionalHotel.isPresent()) {
            return optionalHotel.get();
        } else {
            throw new HotelNotFoundException("Hotel not found with ID: " + hotelId);
        }
    }

    @Override
    public List<RevenueResponse> getRevenueByYear(Integer hotelId, Integer year) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new HotelNotFoundException("Hotel not found"));
        return hotelRepository.getRevenueByYear(hotelId, year);
    }

    @Override
    public List<RevenueResponse> getRevenueForAdminByYear(Integer year) {
        return hotelRepository.getRevenueForAdminByYear(year);
    }

    @Override
    public List<RevenueByYearResponse> getRevenueForAdmin() {
        return hotelRepository.getRevenueForAdmin();
    }

    void updateExtraAmenities(Hotel hotel, List<ExtraService> extraServices) {
        extraServiceRepository.deleteByHotel(hotel);

        for (ExtraService service : extraServices) {
            ExtraService extraService = new ExtraService();
            extraService.setHotel(hotel);
            extraService.setName(service.getName());
            extraService.setPrice(service.getPrice());
            extraService.setDescription(service.getDescription());
            extraServiceRepository.save(extraService);
        }
    }

    void updateHotelAmenities(Hotel hotel, List<AmenityPriceDTO> amenityPrices) {
        hotelHotelAmenityRepository.deleteByHotel(hotel);

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
            hotelHotelAmenityRepository.save(hotelAmenity);
        }
        deleteOrphanedHotelAmenities();
    }

    void deleteOrphanedHotelAmenities() {
        List<HotelAmenity> orphanedAmenities = amenityRepository.findOrphanedAmenities();
        amenityRepository.deleteAll(orphanedAmenities);
    }

    void updateHotelImages(Hotel hotel, List<MultipartFile> images) throws IOException {
        imageRepository.deleteByHotel(hotel);

        List<String> imageUrls = firebaseStorageService.saveImages(images);
        for (String imageUrl : imageUrls) {
            HotelImage image = new HotelImage();
            image.setHotel(hotel);
            image.setImagePath(imageUrl);
            imageRepository.save(image);
        }
    }

    void updateHotel(Hotel hotel, HotelDTO request) {
        hotel.setName(request.getName());
        hotel.setDescription(request.getDescription());
        hotel.setProvince(request.getProvince());
        hotel.setDistrict(request.getDistrict());
        hotel.setWard(request.getWard());
        hotel.setStreet(request.getStreet());
        hotel.setMainPhoneNumber(request.getMainPhoneNumber());
        hotel.setMainEmail(request.getMainEmail());
        hotel.setStatus(request.getStatus());
        hotel.setCheckInTime(request.getCheckInTime());
        hotel.setCheckOutTime(request.getCheckOutTime());
        updateRules(hotel, request.getRules());
        rateRepository.findById(request.getRate()).ifPresent(rate -> {
            hotel.setHotelRate(rate);
            rateRepository.save(rate);
        });
    }

    void updateRules(Hotel hotel, List<String> rules) {
        if (rules != null && !rules.isEmpty()) {
            String concatenatedRules = String.join(", ", rules);
            hotel.setRule(concatenatedRules);
        } else {
            hotel.setRule("");
        }
    }
    void handleSearchRequest(FilterSearchRequest request, CustomSearchResult result, CustomSearchResult firstSearch, int pageIndex, int pageSize) {
        Specification<Hotel> spec;
        if (request.getCount() == 0 && request.getProvince() == null && request.getCheckinDay() == null && request.getCheckoutDay() == null && request.getChildrenCount() == 0 && request.getAdultCount() == 0) {

            spec = HotelSpecifications.withSmallFilters(request);

        } else {
            spec = HotelSpecifications.withFilters(firstSearch, request);

        }
        handleSearchResult(result, pageIndex, pageSize, spec);
        result.setPageIndex(pageIndex + 1);
        result.setPageSize(pageSize);
    }

    void handleSearchResult(CustomSearchResult result, int pageIndex, int pageSize, Specification<Hotel> spec) {
        List<Hotel> hotels = hotelRepository.findAll(spec);
        int pageTotal = calculatePageTotal(hotels.size(), pageSize);
        if (hotels.isEmpty()) {
            throw new ResponseException("No hotel found!");
        }
        if (pageTotal < pageIndex) {
            throw new ResponseException("Page index out of bound!");
        }
        List<HotelFilterSearchResult> searchResults = hotels.stream()
                .map(HotelFilterSearchResult::fromHotel)
                .collect(Collectors.toList());
        List<HotelFilterSearchResult> filteredHotels = getFilteredHotels(searchResults, pageIndex, pageSize);
        if (!hotels.isEmpty()) {
            result.setLocation(hotels.get(0).getProvince());
        }
        result.setHotels(filteredHotels);
        result.setTotalItems((long) hotels.size());
        result.setPageTotal(calculatePageTotal(searchResults.size(), pageSize));
    }

    int calculatePageTotal(long totalItems, int pageSize) {
        return (int) Math.ceil((double) totalItems / pageSize);
    }

    List<HotelFilterSearchResult> getFilteredHotels(List<HotelFilterSearchResult> allHotels, int pageIndex, int pageSize) {

        int start = pageIndex * pageSize;
        int end = Math.min(start + pageSize, allHotels.size());

        return allHotels.subList(start, end);
    }
    Double getMinPriceByHotelId(Hotel hotel) {
        Optional<Double> minPrice = roomTypeRepository.findMinPriceByHotelId(hotel.getId());
        return minPrice.orElse(0.0);

    }

    List<RoomTypeDetails> getRoomTypeDetails(List<RoomType> roomList, LocalDate checkIn, LocalDate checkOut) {
        if (checkIn == null || checkOut == null) {

            return Optional.ofNullable(roomList)
                    .orElse(List.of())
                    .stream()
                    .map(room -> {
                        List<String> firstImageList = getFirstImageByRoom(room.getId());
                        String firstImage = null;

                        if (!firstImageList.isEmpty()) {
                            firstImage = firstImageList.get(0);
                        }
                        return RoomTypeDetails.builder()
                                .id(room.getId())
                                .roomName(room.getName())
                                .price(room.getPrice())
                                .roomImage(firstImage)
                                .quantity(room.getCount())
                                .adult(room.getAdultCount())
                                .children(room.getChildrenCount())
                                .roomAmenities(getListAmenities(room))
                                .build();
                    })
                    .collect(Collectors.toList());
        }
        List<RoomTypeDetails> availableRoomTypes = new ArrayList<>();

        for (RoomType roomType : roomList) {

            List<Room> availableRooms = roomService.getAvailableRooms(roomType, checkIn, checkOut, 100000);
            List<String> firstImageList = getFirstImageByRoom(roomType.getId());
            String firstImage = null;

            if (!firstImageList.isEmpty()) {
                firstImage = firstImageList.get(0);
            }

            RoomTypeDetails roomTypeDetails = RoomTypeDetails.builder()
                    .id(roomType.getId())
                    .roomName(roomType.getName())
                    .price(roomType.getPrice())
                    .roomImage(firstImage)
                    .quantity(availableRooms.size())
                    .adult(roomType.getAdultCount())
                    .children(roomType.getChildrenCount())
                    .roomAmenities(getListAmenities(roomType))
                    .build();

            availableRoomTypes.add(roomTypeDetails);
        }

        return availableRoomTypes;
    }

    String buildAddress(String province, String district, String ward, String street) {

        return province + ", " + district + ", " + ward + ", " + street;
    }

    List<String> getListAmenities(RoomType room) {
        return roomTypeRepository.findAmenitiesByRoomTypeId(room.getId());
    }

    List<String> getFirstImageByRoom(Integer roomId) {
        return roomTypeRepository.findImagesByRoomTypeId(roomId);

    }

    List<ReviewDTO> getReviews(List<Review> reviews) {
        return reviews.stream()
                .map(review -> ReviewDTO.builder()
                        .id(review.getId())
                        .rate(review.getRatingTotal())
                        .review(review.getComment())
                        .build())
                .collect(Collectors.toList());
    }

    List<String> getRules(Hotel hotel) {
        return Arrays.asList(hotel.getRule().split("\\s*,\\s*"));
    }
}


