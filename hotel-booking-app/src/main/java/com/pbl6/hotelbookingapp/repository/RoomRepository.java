package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByRoomTypeId(Integer id);
}
