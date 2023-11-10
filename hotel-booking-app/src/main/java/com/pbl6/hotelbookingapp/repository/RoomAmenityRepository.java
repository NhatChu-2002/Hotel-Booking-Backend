package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.RoomAmenity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomAmenityRepository extends JpaRepository<RoomAmenity, Integer> {
    Optional<RoomAmenity> findByName(String name);
}
