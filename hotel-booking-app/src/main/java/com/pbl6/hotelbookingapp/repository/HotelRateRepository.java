package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.HotelAmenity;
import com.pbl6.hotelbookingapp.entity.HotelRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRateRepository extends JpaRepository<HotelRate, Integer> {

}

