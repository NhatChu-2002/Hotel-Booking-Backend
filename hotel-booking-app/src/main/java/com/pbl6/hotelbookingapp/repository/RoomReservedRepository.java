package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.Reservation;
import com.pbl6.hotelbookingapp.entity.RoomReserved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
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
}
