package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.Hotel;
import com.pbl6.hotelbookingapp.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByHotelId(Integer hotelId);
}
