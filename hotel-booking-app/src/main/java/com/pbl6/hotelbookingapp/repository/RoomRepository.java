package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.Hotel;
import com.pbl6.hotelbookingapp.entity.Room;
import com.pbl6.hotelbookingapp.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query("SELECT r.name FROM Room r WHERE r.id = :roomId")
    String findRoomNameById(@Param("roomId") Long roomId);
    List<Room> findByRoomTypeId(Integer id);
    @Query("SELECT r.roomType FROM Room r WHERE r.id = :roomId")
    RoomType findRoomTypeByRoomId(@Param("roomId") Integer roomId);
    @Query("SELECT r.roomType.hotel FROM Room r WHERE r.id = :roomId")
    Hotel findHotelByRoomId(@Param("roomId") Integer roomId);

    void deleteByRoomType(RoomType roomType);
}
