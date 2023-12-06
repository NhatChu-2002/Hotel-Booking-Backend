package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.entity.BedType;
import com.pbl6.hotelbookingapp.repository.BedTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BedTypeService {
    private final BedTypeRepository bedTypeRepository;


    public List<BedType> getAllBedTypes() {
        return bedTypeRepository.findAll();
    }

    public Optional<BedType> getBedTypeById(Integer id) {
        return bedTypeRepository.findById(id);
    }

    public BedType createOrUpdateBedType(BedType bedType) {
        return bedTypeRepository.save(bedType);
    }

    public void deleteBedTypeById(Integer id) {
        bedTypeRepository.deleteById(id);
    }
    public List<BedType> findByNameContaining(String name) {
        return bedTypeRepository.findByNameContaining(name);
    }

}