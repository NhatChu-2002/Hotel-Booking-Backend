package com.pbl6.hotelbookingapp.controller;


import com.pbl6.hotelbookingapp.Exception.UserNotFoundException;
import com.pbl6.hotelbookingapp.dto.*;
import com.pbl6.hotelbookingapp.entity.User;
import com.pbl6.hotelbookingapp.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/add" , method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<AddHotelResponse> addHotel(@ModelAttribute AddHotelRequest requestDTO, @RequestParam Integer userId) {
        try {
            AddHotelResponse responseDTO = hotelService.addHotel(requestDTO, userId);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new AddHotelResponse("Error adding hotel"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/search")
    public CustomSearchResult searchHotels(@RequestBody SearchRequest request) {
        return hotelService.searchHotels(request);
    }
    @PostMapping("/filter/search")
    public CustomSearchResult filterSearchHotels(@RequestBody FilterSearchRequest request) {
        return hotelService.filterSearchHotel(request);

    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelDetails> getHotelDetails(@PathVariable Integer hotelId) {
        HotelDetails hotelDetails = hotelService.getHotelDetails(hotelId);
        return ResponseEntity.ok(hotelDetails);
    }
}

