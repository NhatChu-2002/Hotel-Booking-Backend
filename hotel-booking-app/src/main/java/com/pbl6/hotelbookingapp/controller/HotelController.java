package com.pbl6.hotelbookingapp.controller;

import com.pbl6.hotelbookingapp.dto.CustomSearchResult;
import com.pbl6.hotelbookingapp.dto.HotelWithTopRating;
import com.pbl6.hotelbookingapp.dto.SearchRequest;
import com.pbl6.hotelbookingapp.service.HotelService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.Set;


@RestController
@RequestMapping("api/hotel")
public class HotelController {
    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/top-4-hotels")
    public Set<HotelWithTopRating> getTop4HotelsWithFirstImage() {
        return hotelService.getTop4HotelsWithFirstImage();
    }

    @PostMapping("/search")
    public CustomSearchResult searchHotels(@RequestBody SearchRequest request) {
        return hotelService.searchHotels(request);
    }
}
