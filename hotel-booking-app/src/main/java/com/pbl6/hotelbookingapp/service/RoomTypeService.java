package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.entity.RoomType;
import com.pbl6.hotelbookingapp.repository.HotelRepository;
import com.pbl6.hotelbookingapp.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomTypeService {
    private RoomTypeRepository roomTypeRepository;
    public RoomTypeService(RoomTypeRepository roomTypeRepository)
    {
        this.roomTypeRepository = roomTypeRepository;
    }
    public Optional<RoomType> findRoomTypeByNameAndHotelId(String name, Integer hotelId) {
        return roomTypeRepository.findFirstByNameAndHotelId(name, hotelId);
    }

}
