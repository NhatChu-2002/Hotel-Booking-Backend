package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.dto.RoomReservedInfoByTime;
import com.pbl6.hotelbookingapp.entity.Reservation;
import com.pbl6.hotelbookingapp.entity.RoomReserved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RoomReservedRepository extends JpaRepository<RoomReserved,Integer> {
    @Query("SELECT rr FROM RoomReserved rr WHERE rr.room.id = :roomId " +
            "AND ((rr.startDay >= :startDay AND rr.startDay <= :endDay) OR " +
            "(rr.endDay >= :startDay AND rr.endDay <= :endDay))")
    List<RoomReserved> checkAvailability(@Param("roomId") Integer roomId,
                                         @Param("startDay") LocalDate startDay,
                                         @Param("endDay") LocalDate endDay);
    List<RoomReserved> findAllByReservation(Reservation reservation);
    @Modifying
    @Query("DELETE FROM RoomReserved rr WHERE rr.reservation = :reservation")
    void deleteAllByReservation(@Param("reservation") Reservation reservation);


    @Query("SELECT new com.pbl6.hotelbookingapp.dto.RoomReservedInfoByTime(" +
            "us.fullName, " +
            "FUNCTION('ROUND', rt.adultCount + rt.childrenCount), " +
            "rr.startDay, " +
            "rr.endDay, " +
            "r.name, " +
            "rs.createdAt, " +
            "rt.price * DATEDIFF(rr.endDay, rr.startDay), " +
            "(rt.price * DATEDIFF(rr.endDay, rr.startDay) * 0.1), " +
            "rr.id) " +
            "FROM Hotel h " +
            "JOIN RoomType rt ON h.id = rt.hotel.id " +
            "JOIN Room r ON rt.id = r.roomType.id " +
            "JOIN RoomReserved rr ON r.id = rr.room.id " +
            "JOIN Reservation rs ON rs.id = rr.reservation.id " +
            "JOIN User us ON us.id = rs.user.id " +
            "WHERE h.id =:hotelId " +
            "AND rr.startDay BETWEEN :startDay AND :endDay " +
            "AND rr.endDay BETWEEN :startDay AND :endDay " +
            "GROUP BY us.fullName, rr.startDay, rr.endDay, r.name, rr.id")
    List<RoomReservedInfoByTime> getListRoomReservedInfo(
            @Param("hotelId") Integer hotelId,
            @Param("startDay") LocalDate startDay,
            @Param("endDay") LocalDate endDay
    );
}
