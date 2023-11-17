package com.pbl6.hotelbookingapp.controller;

import com.pbl6.hotelbookingapp.dto.HotelDTO;
import com.pbl6.hotelbookingapp.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/image")
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping(value = "/hotel/{hotelId}", consumes = {"multipart/form-data"})
    public ResponseEntity<String> uploadHotelImage(@PathVariable Integer hotelId, @ModelAttribute List<MultipartFile> images) {
        try {
            imageService.uploadHotelImage(hotelId, images);
            return new ResponseEntity<>("Images uploaded successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error uploaded images", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/roomType/{roomTypeId}", consumes = {"multipart/form-data"})
    public ResponseEntity<String> uploadRoomTypeImage(@PathVariable Integer roomTypeId, @ModelAttribute List<MultipartFile> images) {
        try {
            imageService.uploadRoomTypeImage(roomTypeId, images);
            return new ResponseEntity<>("Images uploaded successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error uploaded images", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
