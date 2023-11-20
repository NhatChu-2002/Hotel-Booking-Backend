package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.Hotel;
import com.pbl6.hotelbookingapp.entity.HotelImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelImageRepository extends JpaRepository<HotelImage, Integer> {


    void deleteByHotel(Hotel hotel);

    @Query("SELECT hi.imagePath FROM Hotel h JOIN h.hotelImages hi WHERE h.id = :hotelId ORDER BY hi.id ASC LIMIT 1")
    String findFirstImagePathByHotelId(@Param("hotelId") Integer hotelId);
}
