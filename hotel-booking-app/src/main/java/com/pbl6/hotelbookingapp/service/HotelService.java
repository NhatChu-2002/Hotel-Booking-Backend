package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.Exception.ResponseException;
import com.pbl6.hotelbookingapp.dto.*;
import com.pbl6.hotelbookingapp.entity.*;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public interface HotelService {
    Optional<Hotel> findHotelByNameAndProvinceAndStreet(String hotelName, String province, String street);

    Optional<Hotel> findHotelById(Integer id);

    Set<HotelWithTopRating> getTop4HotelsWithFirstImage();

    CustomSearchResult searchHotels(SearchRequest request);

    @Transactional
    AddHotelResponse addHotel(Integer userId, HotelDTO request) throws IOException;

    @Transactional
    void updateHotel(Integer userId, Integer hotelId, HotelDTO request) throws IOException;


    @Transactional
    void deleteHotelById(Integer userId, Integer hotelId);

    CustomSearchResult filterSearchHotel(FilterSearchRequest request);



    HotelDetails getHotelDetails(HotelDetailsRequest request);


    List<String> getHotelImagePaths(Integer hotelId);

    List<String> getAmenityNamesByHotelId(Integer hotelId);

    List<ExtraService> getExtraAmenitiesByHotelId(Integer hotelId);

    Hotel getHotelById(Integer hotelId);

    List<RevenueResponse> getRevenueByYear(Integer hotelId, Integer year);

    List<RevenueResponse> getRevenueForAdminByYear(Integer year);

    List<RevenueByYearResponse> getRevenueForAdmin();
    List<PendingHotelResponse> getPendingHotels();
    void approveHotel(Integer hotelId);
    void declineHotel(Integer hotelId);

}
