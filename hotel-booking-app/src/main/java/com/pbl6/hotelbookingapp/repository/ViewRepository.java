package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.HotelAmenity;
import com.pbl6.hotelbookingapp.entity.View;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ViewRepository extends JpaRepository<View, Integer> {
    Optional<View> findByName(String name);
}
