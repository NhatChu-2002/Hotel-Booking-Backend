package com.pbl6.hotelbookingapp.service;


import com.pbl6.hotelbookingapp.entity.Hotel;
import com.pbl6.hotelbookingapp.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelService {
    private HotelRepository hotelRepository;
    public HotelService(HotelRepository hotelRepository)
    {
        this.hotelRepository = hotelRepository;
    }
    public Optional<Hotel> getHotelByNameAndProvinceAndStreet(String hotelName, String province, String street) {
        return hotelRepository.findFirstByNameAndProvinceAndStreet(hotelName,province, street);
    }
}

