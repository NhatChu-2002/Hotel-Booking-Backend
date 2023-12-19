package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.entity.HotelAmenity;
import com.pbl6.hotelbookingapp.repository.HotelAmenityRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelAmenityServiceImpl implements HotelAmenityService {
    private final HotelAmenityRepository hotelAmenityRepository;


    @Override
    public List<HotelAmenity> getAllHotelAmenities() {
        return hotelAmenityRepository.findAll();
    }

    @Override
    public HotelAmenity getHotelAmenityById(Integer id) {
        return hotelAmenityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("hotel amenity not found with id: " + id));
    }

    @Override
    public HotelAmenity createHotelAmenity(HotelAmenity hotelAmenity) {
        return hotelAmenityRepository.save(hotelAmenity);
    }
    @Override
    @Transactional
    public HotelAmenity updateHotelAmenity(Integer id, HotelAmenity updatedAmenity) {
        HotelAmenity existingAmenity = getHotelAmenityById(id);
        existingAmenity.setName(updatedAmenity.getName());
        existingAmenity.setDescription(updatedAmenity.getDescription());
        return hotelAmenityRepository.save(existingAmenity);
    }
    @Override
    @Transactional
    public void deleteHotelAmenity(Integer id) {
        hotelAmenityRepository.deleteById(id);
    }
}
