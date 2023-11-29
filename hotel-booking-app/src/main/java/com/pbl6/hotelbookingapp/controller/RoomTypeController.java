package com.pbl6.hotelbookingapp.controller;

import com.pbl6.hotelbookingapp.dto.RoomTypeDTO;
import com.pbl6.hotelbookingapp.dto.RoomTypeDetailResponse;
import com.pbl6.hotelbookingapp.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room-types")
@CrossOrigin("${allowed.origins}")
public class RoomTypeController {

    private final RoomTypeService roomTypeService;

    @Autowired
    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @GetMapping(value = "/{roomTypeId}")
    public  RoomTypeDetailResponse getRoomTypeById(@RequestHeader("hotelId") Integer hotelId, @PathVariable Integer roomTypeId) {
        return roomTypeService.findRoomTypeById(hotelId, roomTypeId);
    }

    @RequestMapping(value = "", method = RequestMethod.POST,  consumes = {"multipart/form-data"})
    public ResponseEntity<String> addRoomType(@RequestHeader("hotelId") Integer hotelId, @ModelAttribute RoomTypeDTO roomTypeDTO) {
        try {
            roomTypeService.addRoomType(hotelId, roomTypeDTO);
            return new ResponseEntity<>("Room Type added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding Room Type", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping (value = "/{roomTypeId}", method = RequestMethod.PUT, consumes = {"multipart/form-data"})
    public ResponseEntity<String> updateRoomType(@RequestHeader("hotelId") Integer hotelId, @PathVariable Integer roomTypeId, @ModelAttribute RoomTypeDTO roomTypeDTO) {
        try {
            roomTypeService.updateRoomType(hotelId, roomTypeId, roomTypeDTO);
            return new ResponseEntity<>("Room Type updated successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating Room Type", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{roomTypeId}")
    public ResponseEntity<String> deleteRoomType(@RequestHeader("hotelId") Integer hotelId, @PathVariable Integer roomTypeId) {
        roomTypeService.deleteRoomTypeById(hotelId, roomTypeId);
        return ResponseEntity.ok("Room Type deleted successfully");
    }
}
