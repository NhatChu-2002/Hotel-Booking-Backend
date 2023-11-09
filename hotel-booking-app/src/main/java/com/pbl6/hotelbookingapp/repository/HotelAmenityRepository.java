package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.HotelAmenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface HotelAmenityRepository extends JpaRepository<HotelAmenity, Integer> {
    Optional<HotelAmenity> findByName(String name);
}
