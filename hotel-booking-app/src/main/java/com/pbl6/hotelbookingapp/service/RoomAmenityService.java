package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.dto.AmenitySearchResponse;
import com.pbl6.hotelbookingapp.entity.RoomAmenity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoomAmenityService {
    List<RoomAmenity> getAllRoomAmenities();

    RoomAmenity getRoomAmenityById(Integer id);

    RoomAmenity createRoomAmenity(RoomAmenity roomAmenity);

    @Transactional
    RoomAmenity updateRoomAmenity(Integer id, RoomAmenity updatedAmenity);

    @Transactional
    void deleteRoomAmenity(Integer id);

    AmenitySearchResponse searchAmenities(String keyword, Pageable pageable);
}
