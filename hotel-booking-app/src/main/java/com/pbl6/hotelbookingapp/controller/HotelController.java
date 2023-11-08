package com.pbl6.hotelbookingapp.controller;

import com.pbl6.hotelbookingapp.dto.CustomSearchResult;
import com.pbl6.hotelbookingapp.dto.HotelWithTopRating;
import com.pbl6.hotelbookingapp.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.Set;


@RestController
@RequestMapping("api/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/top-4-hotels")
    public Set<HotelWithTopRating> getTop4HotelsWithFirstImage() {
        return hotelService.getTop4HotelsWithFirstImage();
    }

    @GetMapping("/search")
    public CustomSearchResult searchHotels(
            @RequestParam String province,
            @RequestParam LocalDate checkinDay,
            @RequestParam LocalDate checkoutDay,
            @RequestParam int count,
            @RequestParam int adultCount,
            @RequestParam int childrenCount) {
        return hotelService.searchHotels(province, checkinDay, checkoutDay, count, adultCount, childrenCount);
    }
}