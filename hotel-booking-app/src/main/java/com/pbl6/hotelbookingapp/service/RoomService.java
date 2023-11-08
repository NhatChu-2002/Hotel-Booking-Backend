package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.entity.Room;
import com.pbl6.hotelbookingapp.entity.RoomReserved;
import com.pbl6.hotelbookingapp.entity.RoomType;
import com.pbl6.hotelbookingapp.repository.RoomRepository;
import com.pbl6.hotelbookingapp.repository.RoomReservedRepository;
import com.pbl6.hotelbookingapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomTypeService roomTypeService;
    private final HotelService hotelService;
    private final RoomReservedRepository roomReservedRepository;

    public List<Room> getAvailableRooms(String hotelName,String province,String street, String roomTypeName, Date startDay, Date endDay, int count) {
        List<Room> availableRooms = new ArrayList<>();

        Optional<RoomType> roomType = roomTypeService.findRoomTypeByNameAndHotelId(roomTypeName, hotelService.getHotelByNameAndProvinceAndStreet(hotelName,province,street).get().getId());
        List<Room> rooms = roomRepository.findByRoomTypeId(roomType.get().getId());

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
}
