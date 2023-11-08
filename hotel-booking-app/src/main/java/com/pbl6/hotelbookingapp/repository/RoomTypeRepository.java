package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomTypeRepository extends JpaRepository<RoomType,Integer> {
    Optional<RoomType> findFirstByNameAndHotelId(String name, Integer id);

}
