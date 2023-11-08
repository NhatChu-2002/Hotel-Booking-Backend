package com.pbl6.hotelbookingapp.repository;


import com.pbl6.hotelbookingapp.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {
    Optional<Hotel> findFirstByNameAndProvinceAndStreet(String name, String province, String street);
}
