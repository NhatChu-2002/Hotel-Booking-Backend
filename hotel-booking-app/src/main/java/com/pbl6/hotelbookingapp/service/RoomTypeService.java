package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.Exception.HotelNotFoundException;
import com.pbl6.hotelbookingapp.dto.RoomTypeDTO;
import com.pbl6.hotelbookingapp.dto.BedTypeDTO;
import com.pbl6.hotelbookingapp.entity.*;
import com.pbl6.hotelbookingapp.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class RoomTypeService {
    private RoomTypeRepository roomTypeRepository;

    private HotelRepository hotelRepository;

    private ViewRepository viewRepository;

    private RoomAmenityRepository roomAmenityRepository;

    private RoomImageRepository roomImageRepository;

    private RoomBedTypeRepository roomBedTypeRepository;

    private BedTypeRepository bedTypeRepository;

    private RoomRepository roomRepository;

    private FirebaseStorageService firebaseStorageService;

    public RoomTypeService(RoomTypeRepository roomTypeRepository, HotelRepository hotelRepository, ViewRepository viewRepository, RoomAmenityRepository roomAmenityRepository, RoomImageRepository roomImageRepository, RoomBedTypeRepository roomBedTypeRepository, BedTypeRepository bedTypeRepository, RoomRepository roomRepository, FirebaseStorageService firebaseStorageService) {
        this.roomTypeRepository = roomTypeRepository;
        this.hotelRepository = hotelRepository;
        this.viewRepository = viewRepository;
        this.roomAmenityRepository = roomAmenityRepository;
        this.roomImageRepository = roomImageRepository;
        this.roomBedTypeRepository = roomBedTypeRepository;
        this.bedTypeRepository = bedTypeRepository;
        this.roomRepository = roomRepository;
        this.firebaseStorageService = firebaseStorageService;
    }

    public Optional<RoomType> findRoomTypeByNameAndHotelId(String name, Integer hotelId) {
        return roomTypeRepository.findFirstByNameAndHotelId(name, hotelId);
    }

    @Transactional
    public void addRoomType(Integer hotelId, RoomTypeDTO roomTypeDTO) throws IOException {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        RoomType roomType = new RoomType();
        roomType.setHotel(hotel);
        updateRoomType(roomType, roomTypeDTO);
        Set<RoomAmenity> amenities = updateRoomAmenities(roomTypeDTO.getAmenities());
        roomType.setAmenities(amenities);
        roomTypeRepository.save(roomType);
        updateRoomBedTypes(roomType, roomTypeDTO.getBedTypes());
        updateRoomImages(roomType, roomTypeDTO.getImages());
    }

    @Transactional
    public void updateRoomType(Integer hotelId, Integer roomTypeId, RoomTypeDTO roomTypeDTO) throws IOException {
        RoomType roomType = roomTypeRepository.findByHotelIdAndId(hotelId, roomTypeId);

        updateRoomType(roomType, roomTypeDTO);
        Set<RoomAmenity> amenities = updateRoomAmenities(roomTypeDTO.getAmenities());
        roomType.setAmenities(amenities);
        roomTypeRepository.save(roomType);
        updateRoomBedTypes(roomType, roomTypeDTO.getBedTypes());
        updateRoomImages(roomType, roomTypeDTO.getImages());
    }

    private void updateRoomType(RoomType roomType, RoomTypeDTO roomTypeDTO) {
        roomType.setName(roomTypeDTO.getName());
        roomType.setRoomName(roomTypeDTO.getRoomName());
        roomType.setCount(roomTypeDTO.getCount());
        roomType.setDescription(roomTypeDTO.getDescription());
        roomType.setPrice(roomTypeDTO.getPrice());
        roomType.setBathroomCount(roomTypeDTO.getBathroomCount());
        roomType.setRoomArea(roomTypeDTO.getRoomArea());
        roomType.setAdultCount(roomTypeDTO.getAdultCount());
        roomType.setChildrenCount(roomTypeDTO.getChildrenCount());

        View view = viewRepository.findByName(roomTypeDTO.getView())
                .orElseGet(() -> viewRepository.save(new View(roomTypeDTO.getView())));
        roomType.setView(view);
        roomTypeRepository.save(roomType);


        for (int i = 0; i < roomType.getCount(); i++) {
            Room room = new Room();
            room.setRoomType(roomType);
            String formattedNumber = String.format("%03d", i);
            room.setName(roomType.getRoomName() + formattedNumber);
            roomRepository.save(room);
        }
    }


    private Set<RoomAmenity> updateRoomAmenities(List<String> amenityNames) {
        Set<RoomAmenity> amenities = new HashSet<>();
        for (String amenityName : amenityNames) {
            RoomAmenity roomAmenity = roomAmenityRepository.findByName(amenityName)
                    .orElseGet(() -> roomAmenityRepository.save(new RoomAmenity(amenityName)));
            amenities.add(roomAmenity);
        }
        return amenities;
    }

    private void updateRoomBedTypes(RoomType roomType, List<BedTypeDTO> bedTypes) {
        bedTypes.forEach(bedTypeDTO -> {
            BedType bedType = bedTypeRepository.findByName(bedTypeDTO.getName());
            RoomBedType roomBedType = new RoomBedType();
            roomBedType.setRoomType(roomType);
            roomBedType.setBedType(bedType);
            roomBedType.setCount(bedTypeDTO.getCount());
            roomBedTypeRepository.save(roomBedType);
        });
    }

    private void updateRoomImages(RoomType roomType, List<MultipartFile> images) throws IOException {
        roomImageRepository.deleteByRoomType(roomType);
        List<String> imageUrls = firebaseStorageService.saveImages(images);
        for (String imageUrl : imageUrls) {
            RoomImage image = new RoomImage();
            image.setRoomType(roomType);
            image.setImagePath(imageUrl);
            roomImageRepository.save(image);
        }

    }
}
