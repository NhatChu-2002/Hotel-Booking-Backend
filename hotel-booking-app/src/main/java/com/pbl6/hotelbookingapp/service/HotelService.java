package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.Exception.ResponseException;
import com.pbl6.hotelbookingapp.dto.*;
import com.pbl6.hotelbookingapp.entity.Hotel;
import com.pbl6.hotelbookingapp.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HotelService {
    private HotelRepository hotelRepository;
    public HotelService(HotelRepository hotelRepository)
    {
        this.hotelRepository = hotelRepository;
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
        result.setHotels(hotels);

        Long totalItems = (long) hotels.size();
        result.setTotalItems(totalItems);
        return result;
    }
    public List<HotelFilterSearchResult> filterSearchHotel(FilterSearchRequest request){
        List<Hotel> hotels = hotelRepository.findAll(HotelSpecifications.withFilters(request));
        List<HotelFilterSearchResult> searchResults = hotels.stream()
                .map(HotelFilterSearchResult::fromHotel)
                .collect(Collectors.toList());
        return searchResults;
    }

}

