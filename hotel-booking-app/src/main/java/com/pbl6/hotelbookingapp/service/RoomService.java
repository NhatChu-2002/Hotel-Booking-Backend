package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.dto.ListRoomReservedResponse;
import com.pbl6.hotelbookingapp.dto.TimeReservedRequest;
import com.pbl6.hotelbookingapp.entity.Room;
import com.pbl6.hotelbookingapp.entity.RoomType;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {
    List<Room> getAvailableRooms(RoomType roomType, LocalDate startDay, LocalDate endDay, int count);

    ListRoomReservedResponse getListRoomReservedInfo(Integer hotelId, TimeReservedRequest timeReservedRequest);
}
