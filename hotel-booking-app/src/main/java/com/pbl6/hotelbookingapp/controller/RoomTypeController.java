package com.pbl6.hotelbookingapp.controller;

import com.pbl6.hotelbookingapp.dto.AddHotelRequest;
import com.pbl6.hotelbookingapp.dto.AddHotelResponse;
import com.pbl6.hotelbookingapp.dto.AddRoomTypeRequest;
import com.pbl6.hotelbookingapp.dto.AddRoomTypeResponse;
import com.pbl6.hotelbookingapp.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/room-types")
public class RoomTypeController {

    private final RoomTypeService roomTypeService;

    @Autowired
    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<AddRoomTypeResponse> addRoomType(@ModelAttribute AddRoomTypeRequest addRoomTypeRequest, @RequestParam Integer hotelId) {
        try {
            AddRoomTypeResponse response = roomTypeService.addRoomTypeResponse(addRoomTypeRequest, hotelId);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new AddRoomTypeResponse("Error adding room type"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
