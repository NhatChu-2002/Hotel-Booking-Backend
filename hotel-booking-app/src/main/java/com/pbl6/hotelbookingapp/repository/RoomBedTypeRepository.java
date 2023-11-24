package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.RoomBedType;
import com.pbl6.hotelbookingapp.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomBedTypeRepository extends JpaRepository<RoomBedType, Integer> {
    List<RoomBedType> findByRoomTypeId(Integer roomTypeId);

    void deleteByRoomType(RoomType roomType);
}
