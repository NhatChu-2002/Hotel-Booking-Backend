package com.pbl6.hotelbookingapp.controller;



import com.pbl6.hotelbookingapp.Exception.ResponseException;

import com.pbl6.hotelbookingapp.dto.*;
import com.pbl6.hotelbookingapp.entity.Hotel;
import com.pbl6.hotelbookingapp.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/{userId}" , method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public ResponseEntity<String> addHotel(@PathVariable Integer userId, @ModelAttribute HotelDTO requestDTO) {
        try {
            hotelService.addHotel(userId, requestDTO);
            return new ResponseEntity<>("Hotel added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding hotel", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping (value = "/{userId}/{hotelId}", method = RequestMethod.PUT, consumes = {"multipart/form-data"})
    public ResponseEntity<String> updateHotel(@PathVariable Integer userId, @PathVariable Integer hotelId, @ModelAttribute HotelDTO requestDTO) {
        try {
            hotelService.updateHotel(userId, hotelId, requestDTO);
            return new ResponseEntity<>("Hotel updated successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating hotel", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{userId}/{hotelId}")
    public ResponseEntity<String> deleteHotel(@PathVariable Integer userId, @PathVariable Integer hotelId) {
        hotelService.deleteHotelById(userId, hotelId);
        return ResponseEntity.ok("Hotel deleted successfully");
    }

    @DeleteMapping("/{hotelId}/amenities/{amenityId}")
    public ResponseEntity<String> deleteHotelAmenity(
            @PathVariable Integer hotelId,
            @PathVariable Integer amenityId
    ) {
        try {
            hotelService.deleteHotelAmenity(hotelId, amenityId);
            return new ResponseEntity<>("Amenity deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting amenity", HttpStatus.INTERNAL_SERVER_ERROR);
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
