package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.RoomImage;
import com.pbl6.hotelbookingapp.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomImageRepository extends JpaRepository<RoomImage, Integer> {

    void deleteByRoomType(RoomType roomType);

    List<RoomImage> findByRoomTypeId(Integer roomTypeId);
}
