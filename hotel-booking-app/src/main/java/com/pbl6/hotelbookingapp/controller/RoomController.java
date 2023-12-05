package com.pbl6.hotelbookingapp.controller;

import com.pbl6.hotelbookingapp.dto.ListRoomReservedResponse;
import com.pbl6.hotelbookingapp.dto.RoomReservedInfoByTime;
import com.pbl6.hotelbookingapp.dto.TimeReservedRequest;
import com.pbl6.hotelbookingapp.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    @GetMapping("/reserved-room-info")
    public ListRoomReservedResponse getReservedInfo(
            @RequestHeader Integer hotelId,
            @RequestBody TimeReservedRequest timeReservedRequest) {
        return roomService.getListRoomReservedInfo(hotelId, timeReservedRequest);
    }
}
