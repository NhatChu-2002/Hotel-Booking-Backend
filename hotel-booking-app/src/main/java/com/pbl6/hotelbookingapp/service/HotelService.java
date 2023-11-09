package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.Exception.ResponseException;

import com.pbl6.hotelbookingapp.Exception.UserNotFoundException;
import com.pbl6.hotelbookingapp.dto.*;
import com.pbl6.hotelbookingapp.entity.*;
import com.pbl6.hotelbookingapp.repository.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

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

    public HotelService(HotelRepository hotelRepository, UserRepository userRepository, HotelAmenityRepository amenityRepository, HotelImageRepository imageRepository, HotelRateRepository rateRepository, ResourceLoader resourceLoader) {
        this.hotelRepository = hotelRepository;
        this.userRepository = userRepository;
        this.amenityRepository = amenityRepository;
        this.imageRepository = imageRepository;
        this.rateRepository = rateRepository;
    }


    public Optional<Hotel> findHotelByNameAndProvinceAndStreet(String hotelName, String province, String street) {
        return hotelRepository.findFirstByNameAndProvinceAndStreet(hotelName,province, street);
    }

    public Set<HotelWithTopRating> getTop4HotelsWithFirstImage() {
        return hotelRepository.getTop4HotelsWithFirstImage();
    }
    public CustomSearchResult searchHotels(SearchRequest request) {

        CustomSearchResult result = new CustomSearchResult();
        if(request.getCheckinDay().compareTo(request.getCheckoutDay()) >= 0)
        {
            throw new ResponseException("Check-in date cannot be greater than or equal to check-out date! ");
        }

        List<HotelSearchResult> hotels = hotelRepository.searchHotels(request.getProvince(), request.getCheckinDay(), request.getCheckoutDay(), request.getCount(), request.getAdultCount(), request.getChildrenCount());

        List<HotelFilterSearchResult> filteredHotels = new ArrayList<>();

        for (HotelSearchResult hotel : hotels) {
            HotelFilterSearchResult filteredHotel = new HotelFilterSearchResult();
            filteredHotel.setId(hotel.getHotelId());
            filteredHotel.setHotelName(hotel.getHotelName());
            filteredHotel.setAddress(hotel.getAddress());
            filteredHotel.setHotelImgPath(hotel.getHotelImgPath());

            Optional<Hotel> tempHotel = hotelRepository.findFirstById(hotel.getHotelId());
            Set<String> amenities = hotel.getAmenitiesSet();
            filteredHotel.setAmenities(amenities);
            filteredHotel.setMinPrice(hotel.getMinPrice());
            filteredHotel.setMaxPrice(hotel.getMaxPrice());
            filteredHotel.setReviews(tempHotel.get().getReviews().size());
            filteredHotel.setRating(hotel.getRatingTotal());

            filteredHotels.add(filteredHotel);
        }
        Optional<Hotel> tempHotel = hotelRepository.findFirstById(hotels.get(0).getHotelId());
        Long totalItems = (long) filteredHotels.size();
        result.setHotels(filteredHotels);
        result.setLocation(tempHotel.get().getProvince());
        result.setTotalItems(totalItems);
        
        return result;
    }


    public AddHotelResponse addHotel(AddHotelRequest addHotelRequest, Integer userId) throws IOException {
        Optional<User> userOptional  = userRepository.findById(userId);
        User user = userOptional.get();
        Hotel hotel = new Hotel();
        hotel.setUser(user);
        hotel.setName(addHotelRequest.getName());
        hotel.setDescription(addHotelRequest.getDescription());
        hotel.setProvince(addHotelRequest.getProvince());
        hotel.setDistrict(addHotelRequest.getDistrict());
        hotel.setWard(addHotelRequest.getWard());
        hotel.setStreet(addHotelRequest.getStreet());
        hotel.setCheckInTime(addHotelRequest.getCheckInTime());
        hotel.setCheckOutTime(addHotelRequest.getCheckOutTime());
        for (String rule : addHotelRequest.getRules()) {
            hotel.setRule(rule);
        }

        HotelRate rate = rateRepository.findById(addHotelRequest.getRate()).orElse(null);
        hotel.setHotelRate(rate);

        Set<HotelAmenity> amenities = new HashSet<>();
        for (String amenityName : addHotelRequest.getAmenities()) {
            HotelAmenity amenity = amenityRepository.findByName(amenityName).orElse(null);
            if (amenity == null) {
                amenity = new HotelAmenity();
                amenity.setName(amenityName);
                amenityRepository.save(amenity);
            }
            amenities.add(amenity);
        }
        hotel.setHotelAmenities(amenities);
        hotelRepository.save(hotel);

        List<String> imagePaths = saveImages(addHotelRequest.getImages());
        for (String imagePath : imagePaths) {
            HotelImage image = new HotelImage();
            image.setHotel(hotel);
            image.setImagePath(imagePath);
            imageRepository.save(image);
        }
        AddHotelResponse responseDTO = new AddHotelResponse();
        responseDTO.setMessage("Hotel added successfully");
        return responseDTO;
    }

    public List<String> saveImages(List<MultipartFile> images) throws IOException {
        List<String> imagePaths = new ArrayList<>();
        String currentDirectory = new File("").getAbsolutePath();
        String staticPath = currentDirectory + "/src/main/resources/static";
        String uploadDir = staticPath + File.separator + "images";

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

    public CustomSearchResult filterSearchHotel(FilterSearchRequest request){
        CustomSearchResult result = new CustomSearchResult();

        List<Hotel> hotels = hotelRepository.findAll(HotelSpecifications.withFilters(request));
        List<HotelFilterSearchResult> searchResults = hotels.stream()
                .map(HotelFilterSearchResult::fromHotel)
                .collect(Collectors.toList());
        result.setHotels(searchResults);
        result.setTotalItems((long) searchResults.size());
        if(searchResults.isEmpty())
        {
            result.setLocation(null);
        }
        else result.setLocation(hotels.get(0).getProvince());

        return result;
    }




