package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.Reservation;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findAllByUserId(Integer id);
    Optional<Reservation> findFirstById(Integer id);
    Optional<Reservation> findFirstByReservationCode(String code);
}
