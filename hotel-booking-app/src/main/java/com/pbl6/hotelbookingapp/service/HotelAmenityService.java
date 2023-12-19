package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.entity.HotelAmenity;
import jakarta.transaction.Transactional;

import java.util.List;

public interface HotelAmenityService {
    List<HotelAmenity> getAllHotelAmenities();

    HotelAmenity getHotelAmenityById(Integer id);

    HotelAmenity createHotelAmenity(HotelAmenity hotelAmenity);

    @Transactional
    HotelAmenity updateHotelAmenity(Integer id, HotelAmenity updatedAmenity);

    @Transactional
    void deleteHotelAmenity(Integer id);
}
