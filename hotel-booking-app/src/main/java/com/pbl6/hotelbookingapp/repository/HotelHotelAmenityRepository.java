package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.Hotel;
import com.pbl6.hotelbookingapp.entity.HotelHotelAmenity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotelHotelAmenityRepository extends JpaRepository<HotelHotelAmenity, Integer> {
    List<HotelHotelAmenity> findByHotel(Hotel hotel);

    Optional<HotelHotelAmenity> findByHotelIdAndHotelAmenityId(Integer hotelId, Integer amenityId);

    List<HotelHotelAmenity> findByHotelAmenityId(Integer amenityId);

    List<HotelHotelAmenity> findByHotelId(Integer hotelId);

    void deleteByHotelId(Integer hotelId);

    boolean existsByHotelAmenityId(Integer amenityId);
}
