package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.dto.AmenitySearchResponse;
import com.pbl6.hotelbookingapp.entity.HotelAmenity;
import com.pbl6.hotelbookingapp.entity.RoomAmenity;
import com.pbl6.hotelbookingapp.repository.HotelAmenityRepository;
import com.pbl6.hotelbookingapp.repository.RoomAmenityRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomAmenityService {
    private final RoomAmenityRepository roomAmenityRepository;
    private final HotelAmenityRepository hotelAmenityRepository;


    public List<RoomAmenity> getAllRoomAmenities() {
        return roomAmenityRepository.findAll();
    }

    public RoomAmenity getRoomAmenityById(Integer id) {
        return roomAmenityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("room amenity not found with id: " + id));
    }

    public RoomAmenity createRoomAmenity(RoomAmenity roomAmenity) {
        return roomAmenityRepository.save(roomAmenity);
    }
    @Transactional
    public RoomAmenity updateRoomAmenity(Integer id, RoomAmenity updatedAmenity) {
        RoomAmenity existingAmenity = getRoomAmenityById(id);
        existingAmenity.setName(updatedAmenity.getName());
        return roomAmenityRepository.save(existingAmenity);
    }
    @Transactional
    public void deleteRoomAmenity(Integer id) {
        roomAmenityRepository.deleteById(id);
    }
    public AmenitySearchResponse searchAmenities(String keyword, Pageable pageable) {
        Page<HotelAmenity> hotelAmenitiesPage = hotelAmenityRepository.findByNameContaining(keyword, pageable);
        Page<RoomAmenity> roomAmenitiesPage = roomAmenityRepository.findByNameContaining(keyword, pageable);


        List<HotelAmenity> hotelAmenities = hotelAmenitiesPage.getContent();
        List<RoomAmenity> roomAmenities = roomAmenitiesPage.getContent();


        return new AmenitySearchResponse(hotelAmenities, roomAmenities);
    }
}
