package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.ExtraService;
import com.pbl6.hotelbookingapp.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExtraServiceRepository extends JpaRepository<ExtraService, Integer> {
    List<ExtraService> findByHotelId(Integer hotelId);
    void deleteByHotel(Hotel hotel);
}
