package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.entity.BedType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BedTypeService {
    List<BedType> getAllBedTypes();

    Optional<BedType> getBedTypeById(Integer id);

    BedType createOrUpdateBedType(BedType bedType);

    void deleteBedTypeById(Integer id);

    Page<BedType> findBedTypesByNameContaining(String name, Pageable pageable);
}
