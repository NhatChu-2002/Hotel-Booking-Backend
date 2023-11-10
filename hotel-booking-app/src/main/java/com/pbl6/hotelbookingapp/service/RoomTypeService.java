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

    public RoomTypeService(RoomTypeRepository roomTypeRepository, HotelRepository hotelRepository, ViewRepository viewRepository, RoomAmenityRepository roomAmenityRepository, RoomImageRepository roomImageRepository, RoomBedTypeRepository roomBedTypeRepository, BedTypeRepository bedTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
        this.hotelRepository = hotelRepository;
        this.viewRepository = viewRepository;
        this.roomAmenityRepository = roomAmenityRepository;
        this.roomImageRepository = roomImageRepository;
        this.roomBedTypeRepository = roomBedTypeRepository;
        this.bedTypeRepository = bedTypeRepository;
    }

    public Optional<RoomType> findRoomTypeByNameAndHotelId(String name, Integer hotelId) {
        return roomTypeRepository.findFirstByNameAndHotelId(name, hotelId);
    }


    public AddRoomTypeResponse addRoomTypeResponse(AddRoomTypeRequest addRoomTypeRequest, Integer hotelId) throws IOException {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        RoomType roomType = createRoomType(addRoomTypeRequest, hotel);

        Set<RoomAmenity> amenities = addOrUpdateRoomAmenities(addRoomTypeRequest.getAmenities());
        roomType.setAmenities(amenities);
        roomTypeRepository.save(roomType);

        addRoomBedTypes(roomType, addRoomTypeRequest.getBedTypes());

        List<String> imagePaths = saveImages(addRoomTypeRequest.getImages());
        addRoomImages(roomType, imagePaths);

        AddRoomTypeResponse addRoomTypeResponse = new AddRoomTypeResponse();
        addRoomTypeResponse.setMessage("Roomtype added successfully");
        return addRoomTypeResponse;
    }

    private RoomType createRoomType(AddRoomTypeRequest addRoomTypeRequest, Hotel hotel) {
        RoomType roomType = new RoomType();
        roomType.setHotel(hotel);
        roomType.setName(addRoomTypeRequest.getName());
        roomType.setCount(addRoomTypeRequest.getCount());
        roomType.setDescription(addRoomTypeRequest.getDescription());
        roomType.setPrice(addRoomTypeRequest.getPrice());
        roomType.setBathroomCount(addRoomTypeRequest.getBathroom_count());
        roomType.setRoomArea(addRoomTypeRequest.getRoom_area());
        roomType.setAdultCount(addRoomTypeRequest.getAdult_count());
        roomType.setChildrenCount(addRoomTypeRequest.getChildren_count());

        View view = viewRepository.findByName(addRoomTypeRequest.getView())
                .orElseGet(() -> viewRepository.save(new View(addRoomTypeRequest.getView())));
        roomType.setView(view);

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

    private void addRoomImages(RoomType roomType, List<String> imagePaths) {
        imagePaths.forEach(imagePath -> {
            RoomImage image = new RoomImage();
            image.setRoomType(roomType);
            image.setImagePath(imagePath);
            roomImageRepository.save(image);
        });
    }

    public List<String> saveImages(List<MultipartFile> images) throws IOException {
        List<String> imagePaths = new ArrayList<>();
        String currentDirectory = new File("").getAbsolutePath();
        String staticPath = currentDirectory + "/src/main/resources/static";
        String uploadDir = staticPath + File.separator + "images/room";

        File uploadDirFile = new File(uploadDir);
        if (!uploadDirFile.exists()) {
            uploadDirFile.mkdirs();
        }
        for (MultipartFile image : images) {
            String imagePath = uploadDir + File.separator + image.getOriginalFilename();
            image.transferTo(new File(imagePath));
            imagePaths.add(imagePath);
        }
        return imagePaths;
    }

}
