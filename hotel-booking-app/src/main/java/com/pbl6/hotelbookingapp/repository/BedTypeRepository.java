package com.pbl6.hotelbookingapp.repository;

import com.pbl6.hotelbookingapp.entity.BedType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BedTypeRepository extends JpaRepository<BedType, Integer> {
    BedType findByName(String name);
     Page<BedType> findByNameContaining(String name, Pageable pageable);
}
