package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.Reservation;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
