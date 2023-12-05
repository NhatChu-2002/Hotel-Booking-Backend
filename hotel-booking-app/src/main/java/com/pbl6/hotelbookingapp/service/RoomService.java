package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.Exception.HotelNotFoundException;
import com.pbl6.hotelbookingapp.dto.ListRoomReservedResponse;
import com.pbl6.hotelbookingapp.dto.RoomReservedInfoByTime;
import com.pbl6.hotelbookingapp.dto.TimeReservedRequest;
import com.pbl6.hotelbookingapp.entity.Hotel;
import com.pbl6.hotelbookingapp.entity.Room;
import com.pbl6.hotelbookingapp.entity.RoomReserved;
import com.pbl6.hotelbookingapp.entity.RoomType;
import com.pbl6.hotelbookingapp.repository.HotelRepository;
import com.pbl6.hotelbookingapp.repository.RoomRepository;
import com.pbl6.hotelbookingapp.repository.RoomReservedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final RoomReservedRepository roomReservedRepository;

    public List<Room> getAvailableRooms(RoomType roomType, LocalDate startDay, LocalDate endDay, int count) {
        List<Room> availableRooms = new ArrayList<>();

        List<Room> rooms = roomRepository.findByRoomTypeId(roomType.getId());

        for (Room room : rooms) {

            List<RoomReserved> roomReserved= roomReservedRepository.checkAvailability(room.getId(), startDay, endDay);

            if (roomReserved.isEmpty()) {
                availableRooms.add(room);

                if (availableRooms.size() >= count) {
                    break; // Đã tìm đủ số lượng phòng cần đặt
                }
            }
        }

        return availableRooms;
    }

    public ListRoomReservedResponse getListRoomReservedInfo(Integer hotelId, TimeReservedRequest timeReservedRequest) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        List<RoomReservedInfoByTime> roomReservedInfoList = roomReservedRepository.getListRoomReservedInfo(hotelId, timeReservedRequest.getStartDay(), timeReservedRequest.getEndDay());

        Double totalPrice = 0.0;
        Double totalCommission = 0.0;

        for (RoomReservedInfoByTime roomReservedInfo : roomReservedInfoList) {
            totalPrice += roomReservedInfo.getPrice();
            totalCommission += roomReservedInfo.getCommission();
        }

        return ListRoomReservedResponse.builder()
                .roomReservedInfoByTime(roomReservedInfoList)
                .totalPrice(totalPrice)
                .totalCommission(totalCommission)
                .build();
    }

}
