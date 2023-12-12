package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.Role;
import com.pbl6.hotelbookingapp.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(Integer id);
    Optional<User> findByEmail(String email);
    Page<User> findByEmailIgnoreCaseContaining(String email, Pageable pageable);
    User findByEmailIgnoreCase(String email);
    Boolean existsByEmail(String email);

    @Modifying
    @Query("UPDATE User u SET u.fullName=:fullName, u.gender = :gender, u.phoneNumber = :phoneNumber, u.dateOfBirth = :dateOfBirth WHERE u.id = :id")
    void updateUserDetails(@Param("id") Integer id,
                           @Param("fullName") String fullName,
                           @Param("phoneNumber") String phoneNumber,
                           @Param("gender") Boolean gender,
                           @Param("dateOfBirth") @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateOfBirth
                           );
    @Modifying
    @Query("UPDATE User u SET u.fullName = :fullName, u.password = :password, u.role = :role WHERE u.id = :id")
    void updateUserDetails(@Param("id") Integer id,
                           @Param("fullName") String fullName,
                           @Param("password") String password,
                           @Param("role") Role role
    );



    List<User> findAll();
    boolean existsByEmailAndIdNot(String email, Integer id);
    Page<User> findByIsDeletedFalse(Pageable pageable);
}
