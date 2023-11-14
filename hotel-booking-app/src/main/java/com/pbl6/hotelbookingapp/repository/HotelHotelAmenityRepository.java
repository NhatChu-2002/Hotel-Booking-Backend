package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.Hotel;
import com.pbl6.hotelbookingapp.entity.HotelHotelAmenity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelHotelAmenityRepository extends JpaRepository<HotelHotelAmenity, Integer> {
    List<HotelHotelAmenity> findByHotel(Hotel hotel);

}
