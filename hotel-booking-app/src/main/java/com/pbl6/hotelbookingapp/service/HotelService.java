package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.dto.CustomSearchResult;
import com.pbl6.hotelbookingapp.dto.HotelWithTopRating;
import com.pbl6.hotelbookingapp.dto.HotelSearchResult;
import com.pbl6.hotelbookingapp.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public Set<HotelWithTopRating> getTop4HotelsWithFirstImage() {
        return hotelRepository.getTop4HotelsWithFirstImage();
    }
    public CustomSearchResult searchHotels(
            String province, LocalDate checkinDay, LocalDate checkoutDay, int count,
            int adultCount, int childrenCount) {

        CustomSearchResult result = new CustomSearchResult();

        List<HotelSearchResult> hotels = hotelRepository.searchHotels(
                province, checkinDay, checkoutDay, count, adultCount, childrenCount
        );
        result.setHotels(hotels);

        Long totalItems = (long) hotels.size();
        result.setTotalItems(totalItems);
        return result;
    }
}



