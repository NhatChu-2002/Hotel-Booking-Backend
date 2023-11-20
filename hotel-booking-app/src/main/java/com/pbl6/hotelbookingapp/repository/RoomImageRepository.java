package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.RoomImage;
import com.pbl6.hotelbookingapp.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomImageRepository extends JpaRepository<RoomImage, Integer> {

    void deleteByRoomType(RoomType roomType);
}
