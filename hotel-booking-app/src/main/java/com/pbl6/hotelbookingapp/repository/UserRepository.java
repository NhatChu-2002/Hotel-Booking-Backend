package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    @Modifying
    @Query("UPDATE User u SET u.fullName=:fullName, u.gender = :gender, u.email = :email, u.phoneNumber = :phoneNumber, u.dateOfBirth = :dateOfBirth WHERE u.id = :id")
    void updateUserDetails(@Param("id") Integer id,
                           @Param("fullName") String fullName,
                           @Param("email") String email,
                           @Param("phoneNumber") String phoneNumber,
                           @Param("gender") Boolean gender,
                           @Param("dateOfBirth") @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateOfBirth
                           );
    List<User> findAll();
    boolean existsByEmailAndIdNot(String email, Integer id);
}
