package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.HotelImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelImageRepository extends JpaRepository<HotelImage, Integer> {

}
