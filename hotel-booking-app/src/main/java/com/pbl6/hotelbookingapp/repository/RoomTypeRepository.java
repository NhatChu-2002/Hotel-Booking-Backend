package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.dto.RoomAvailableResponse;
import com.pbl6.hotelbookingapp.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RoomTypeRepository extends JpaRepository<RoomType,Integer> {

    Optional<RoomType> findFirstByIdAndHotelId(Integer roomTypeId, Integer hotelId);

    @Query("SELECT ri.imagePath FROM RoomType r JOIN r.roomImages ri WHERE r.id = :roomTypeId")
    List<String> findImagesByRoomTypeId(@Param("roomTypeId") Integer roomTypeId);

    @Query("SELECT a.name FROM  RoomType r JOIN  r.amenities a WHERE r.id = :roomTypeId")
    List<String> findAmenitiesByRoomTypeId(@Param("roomTypeId") Integer roomTypeId);

    @Query("SELECT MIN(rt.price) FROM RoomType rt WHERE rt.hotel.id = :hotelId")
    Optional<Double> findMinPriceByHotelId(@Param("hotelId") Integer hotelId);

    RoomType findByHotelIdAndId(Integer hotelId, Integer roomTypeId);

    List<RoomType> findByHotelId(Integer hotelId);
    @Query("SELECT new com.pbl6.hotelbookingapp.dto.RoomAvailableResponse(" +
            "rt.name, " +
            "rt.price, " +
            "rt.count - COUNT(rr.id)) " +
            "FROM Hotel h " +
            "JOIN RoomType rt ON h.id = rt.hotel.id " +
            "LEFT JOIN RoomReserved rr ON rr.room.roomType.id = rt.id " +
            "                           AND :endDate >= rr.startDay " +
            "                           AND :startDate <= rr.endDay " +
            "WHERE h.id = :hotelId " +
            "GROUP BY rt.name, rt.price, rt.count")
    List<RoomAvailableResponse> getAvailableRooms(
            @Param("hotelId") Integer hotelId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

}
