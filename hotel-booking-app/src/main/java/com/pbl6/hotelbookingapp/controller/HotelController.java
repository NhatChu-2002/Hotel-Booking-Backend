package com.pbl6.hotelbookingapp.controller;


import com.pbl6.hotelbookingapp.Exception.ResponseException;
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
    public ResponseEntity<AddHotelResponse> addHotel(@ModelAttribute AddHotelRequest requestDTO) {
        try {
            AddHotelResponse responseDTO = hotelService.addHotel(requestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new AddHotelResponse("Error adding hotel"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/search")
    public ResponseEntity<?> searchHotels(@RequestBody SearchRequest request) {

        try{
            CustomSearchResult response = hotelService.searchHotels(request);

            return ResponseEntity.ok().body(response);
        }
        catch(ResponseException e)
        {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(e.getMessage()));
        }
    }
    @PostMapping("/filter/search")
    public ResponseEntity<?> filterSearchHotels(@RequestBody FilterSearchRequest request) {
        try{
            CustomSearchResult response = hotelService.filterSearchHotel(request);

            return ResponseEntity.ok().body(response);
        }
        catch(ResponseException e)
        {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(e.getMessage()));
        }

    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<?> getHotelDetails(@PathVariable Integer hotelId) {
        try{
            HotelDetails hotelDetails = hotelService.getHotelDetails(hotelId);
            return ResponseEntity.ok(hotelDetails);
        }
        catch(ResponseException e)
        {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(e.getMessage()));
        }

    }
}
