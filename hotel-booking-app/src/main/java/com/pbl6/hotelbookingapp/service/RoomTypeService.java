package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.Exception.HotelNotFoundException;
import com.pbl6.hotelbookingapp.dto.AddRoomTypeRequest;
import com.pbl6.hotelbookingapp.dto.AddRoomTypeResponse;
import com.pbl6.hotelbookingapp.dto.BedTypeDTO;
import com.pbl6.hotelbookingapp.entity.*;
import com.pbl6.hotelbookingapp.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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

    public Optional<RoomType> findRoomTypeByIdAndHotelId(Integer id, Integer hotelId) {
        return roomTypeRepository.findFirstByIdAndHotelId(id, hotelId);
    }


    public AddRoomTypeResponse addRoomTypeResponse(AddRoomTypeRequest addRoomTypeRequest) throws IOException {
        Hotel hotel = hotelRepository.findById(addRoomTypeRequest.getHotelId())
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        RoomType roomType = createRoomType(addRoomTypeRequest, hotel);

        Set<RoomAmenity> amenities = addOrUpdateRoomAmenities(addRoomTypeRequest.getAmenities());
        roomType.setAmenities(amenities);
        roomTypeRepository.save(roomType);

        addRoomBedTypes(roomType, addRoomTypeRequest.getBedTypes());

        addRoomImages(roomType, addRoomTypeRequest.getImages());

        AddRoomTypeResponse addRoomTypeResponse = new AddRoomTypeResponse();
        addRoomTypeResponse.setMessage("Roomtype added successfully");
        return addRoomTypeResponse;
    }

    private RoomType createRoomType(AddRoomTypeRequest addRoomTypeRequest, Hotel hotel) {
        RoomType roomType = new RoomType();
        roomType.setHotel(hotel);
        roomType.setName(addRoomTypeRequest.getName());
        roomType.setRoomName(addRoomTypeRequest.getRoomName());
        roomType.setCount(addRoomTypeRequest.getCount());
        roomType.setDescription(addRoomTypeRequest.getDescription());
        roomType.setPrice(addRoomTypeRequest.getPrice());
        roomType.setBathroomCount(addRoomTypeRequest.getBathroomCount());
        roomType.setRoomArea(addRoomTypeRequest.getRoomArea());
        roomType.setAdultCount(addRoomTypeRequest.getAdultCount());
        roomType.setChildrenCount(addRoomTypeRequest.getChildrenCount());

        View view = viewRepository.findByName(addRoomTypeRequest.getView())
                .orElseGet(() -> viewRepository.save(new View(addRoomTypeRequest.getView())));
        roomType.setView(view);
        roomTypeRepository.save(roomType);


        for (int i = 0; i < roomType.getCount(); i++) {
            Room room = new Room();
            room.setRoomType(roomType);
            String formattedNumber = String.format("%03d", i);
            room.setName(roomType.getRoomName() + formattedNumber);
            roomRepository.save(room);
        }
        return roomType;
    }

    private Set<RoomAmenity> addOrUpdateRoomAmenities(List<String> amenityNames) {
        Set<RoomAmenity> amenities = new HashSet<>();
        for (String amenityName : amenityNames) {
            RoomAmenity roomAmenity = roomAmenityRepository.findByName(amenityName)
                    .orElseGet(() -> roomAmenityRepository.save(new RoomAmenity(amenityName)));
            amenities.add(roomAmenity);
        }
        return amenities;
    }

    private void addRoomBedTypes(RoomType roomType, List<BedTypeDTO> bedTypes) {
        bedTypes.forEach(bedTypeDTO -> {
            BedType bedType = bedTypeRepository.findByName(bedTypeDTO.getName());
            RoomBedType roomBedType = new RoomBedType();
            roomBedType.setRoomType(roomType);
            roomBedType.setBedType(bedType);
            roomBedType.setCount(bedTypeDTO.getCount());
            roomBedTypeRepository.save(roomBedType);
        });
    }

    private void addRoomImages(RoomType roomType, List<MultipartFile> images) throws IOException {
        List<String> imageUrls = firebaseStorageService.saveImages(images);
        for (String imageUrl : imageUrls) {
            RoomImage image = new RoomImage();
            image.setRoomType(roomType);
            image.setImagePath(imageUrl);
            roomImageRepository.save(image);
        }
    }

}
