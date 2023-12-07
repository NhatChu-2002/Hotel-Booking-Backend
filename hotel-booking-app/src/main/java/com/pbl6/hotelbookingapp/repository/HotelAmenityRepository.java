package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.HotelAmenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelAmenityRepository extends JpaRepository<HotelAmenity, Integer> {
    Optional<HotelAmenity> findByName(String name);

    @Query("SELECT a FROM HotelAmenity a WHERE NOT EXISTS (SELECT 1 FROM HotelHotelAmenity ha WHERE ha.hotelAmenity = a)")
    List<HotelAmenity> findOrphanedAmenities();
    List<HotelAmenity> findByNameContaining(String keyword);
}
