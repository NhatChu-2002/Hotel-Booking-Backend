package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.ExtraService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExtraServiceRepository extends JpaRepository<ExtraService, Integer> {
    List<ExtraService> findByHotelId(Integer hotelId);
}
