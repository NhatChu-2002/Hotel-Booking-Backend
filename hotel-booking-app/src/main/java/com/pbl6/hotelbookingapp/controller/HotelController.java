package com.pbl6.hotelbookingapp.controller;

import com.pbl6.hotelbookingapp.dto.*;
import com.pbl6.hotelbookingapp.service.HotelService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
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
    @PostMapping("/filter/search")
    public List<HotelFilterSearchResult> filterSearchHotels(@RequestBody FilterSearchRequest request) {
        return hotelService.filterSearchHotel(request);
    }
}
