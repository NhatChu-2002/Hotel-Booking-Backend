package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.Exception.HotelNotFoundException;
import com.pbl6.hotelbookingapp.dto.*;
import com.pbl6.hotelbookingapp.entity.*;
import com.pbl6.hotelbookingapp.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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

    private RoomReservedRepository roomReservedRepository;

    private UserRepository userRepository;

    private ReservationRepository reservationRepository;

    private FirebaseStorageService firebaseStorageService;

    public RoomTypeService(RoomTypeRepository roomTypeRepository, HotelRepository hotelRepository, ViewRepository viewRepository, RoomAmenityRepository roomAmenityRepository, RoomImageRepository roomImageRepository, RoomBedTypeRepository roomBedTypeRepository, BedTypeRepository bedTypeRepository, RoomRepository roomRepository, RoomReservedRepository roomReservedRepository, UserRepository userRepository, ReservationRepository reservationRepository, FirebaseStorageService firebaseStorageService) {
        this.roomTypeRepository = roomTypeRepository;
        this.hotelRepository = hotelRepository;
        this.viewRepository = viewRepository;
        this.roomAmenityRepository = roomAmenityRepository;
        this.roomImageRepository = roomImageRepository;
        this.roomBedTypeRepository = roomBedTypeRepository;
        this.bedTypeRepository = bedTypeRepository;
        this.roomRepository = roomRepository;
        this.roomReservedRepository = roomReservedRepository;
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
        this.firebaseStorageService = firebaseStorageService;
    }

    public Optional<RoomType> findRoomTypeByIdAndHotelId(Integer id, Integer hotelId) {
        return roomTypeRepository.findFirstByIdAndHotelId(id, hotelId);
    }

    @Transactional
    public AddRoomTypeResponse addRoomType(Integer hotelId, RoomTypeDTO roomTypeDTO) throws IOException {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        RoomType roomType = new RoomType();
        roomType.setHotel(hotel);
        updateRoomType(roomType, roomTypeDTO);
        Set<RoomAmenity> amenities = updateRoomAmenities(roomType, roomTypeDTO.getAmenities());
        roomType.setAmenities(amenities);
        roomTypeRepository.save(roomType);
        updateRoomBedTypes(roomType, roomTypeDTO.getBedTypes());
        updateRoomImages(roomType, roomTypeDTO.getImages());
        return new AddRoomTypeResponse(roomType.getId());
    }

    @Transactional
    public void updateRoomType(Integer hotelId, Integer roomTypeId, RoomTypeDTO roomTypeDTO) throws IOException {
        RoomType roomType = roomTypeRepository.findByHotelIdAndId(hotelId, roomTypeId);

        updateRoomType(roomType, roomTypeDTO);
        Set<RoomAmenity> amenities = updateRoomAmenities(roomType, roomTypeDTO.getAmenities());
        roomType.setAmenities(amenities);
        roomTypeRepository.save(roomType);
        updateRoomBedTypes(roomType, roomTypeDTO.getBedTypes());
        updateRoomImages(roomType, roomTypeDTO.getImages());
    }

    private void updateRoomType(RoomType roomType, RoomTypeDTO roomTypeDTO) {
        roomType.setName(roomTypeDTO.getName());
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


        roomRepository.deleteByRoomType(roomType);
        List<String> sdRoomNames = roomTypeDTO.getSdRoomName();

        for (int i = 0; i < roomType.getCount(); i++) {
            Room room = new Room();
            room.setRoomType(roomType);
            if (roomTypeDTO.getRoomName() != null && !roomTypeDTO.getRoomName().trim().isEmpty()) {
                String formattedNumber = String.format("%03d", i);
                room.setName(roomTypeDTO.getRoomName() + formattedNumber);
            } else {
                room.setName(sdRoomNames.get(i));
            }
            roomRepository.save(room);
        }
    }


    private Set<RoomAmenity> updateRoomAmenities(RoomType roomType, List<String> amenityNames) {
        roomBedTypeRepository.deleteByRoomType(roomType);
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

    @Transactional
    public void deleteRoomTypeById(Integer hotelId, Integer roomTypeId) {
        RoomType roomType = roomTypeRepository.findByHotelIdAndId(hotelId, roomTypeId);
        roomTypeRepository.delete(roomType);
    }

    public RoomTypeDetailResponse findRoomTypeById(Integer hotelId, Integer roomTypeId) {
        RoomTypeDetailResponse roomTypeDetailResponse = new RoomTypeDetailResponse();
        RoomType roomType = roomTypeRepository.findByHotelIdAndId(hotelId, roomTypeId);
        roomTypeDetailResponse.setName(roomType.getName());
        roomTypeDetailResponse.setCount(roomType.getCount());
        roomTypeDetailResponse.setPrice(roomType.getPrice());
        roomTypeDetailResponse.setBathroomCount(roomType.getBathroomCount());
        roomTypeDetailResponse.setRoomArea(roomType.getRoomArea());
        roomTypeDetailResponse.setAdultCount(roomType.getAdultCount());
        roomTypeDetailResponse.setChildrenCount(roomType.getChildrenCount());
        roomTypeDetailResponse.setDescription(roomType.getDescription());
        roomTypeDetailResponse.setBedTypes(getBedTypes(roomTypeId));
        roomTypeDetailResponse.setAmenities(getAmenities(roomTypeId));
        roomTypeDetailResponse.setView(getView(roomTypeId));
        roomTypeDetailResponse.setImages(getImagePaths(roomTypeId));
        roomTypeDetailResponse.setRooms(getRoomNames(roomTypeId));
        return roomTypeDetailResponse;
    }

    public List<String> getImagePaths(Integer roomTypeId) {
        return roomImageRepository.findByRoomTypeId(roomTypeId).stream()
                .map(RoomImage::getImagePath)
                .collect(Collectors.toList());
    }

    private List<String> getAmenities(Integer roomTypeId) {
        return roomTypeRepository.findById(roomTypeId)
                .map(roomType -> roomType.getAmenities().stream()
                        .map(RoomAmenity::getName)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }
    private List<String> getRoomNames(Integer roomTypeId) {
        return roomRepository.findByRoomTypeId(roomTypeId).stream()
                .map(Room::getName)
                .collect(Collectors.toList());
    }

    private String getView(Integer roomTypeId) {
        return roomTypeRepository.findById(roomTypeId)
                .map(roomType -> viewRepository.findById(roomType.getView().getId()))
                .map(view -> view.map(View::getName).orElse(null))
                .orElse(null);
    }

    private List<BedTypeDTO> getBedTypes(Integer roomTypeId){
            return roomBedTypeRepository.findByRoomTypeId(roomTypeId).stream()
                    .map(roomBedType -> {
                        BedType bedType = bedTypeRepository.findById(roomBedType.getBedType().getId()).orElseThrow();
                        BedTypeDTO bedTypeDTO = new BedTypeDTO();
                        bedTypeDTO.setName(bedType.getName());
                        bedTypeDTO.setCount(roomBedType.getCount());
                        return bedTypeDTO;
                    })
                    .collect(Collectors.toList());
        }

    public RoomTypesOfHotelResponse findRoomTypesByHotelId(Integer hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new HotelNotFoundException("Hotel not found!!"));
        List<RoomType> roomTypes = roomTypeRepository.findByHotelId(hotelId);

        List<RoomTypeDetailResponse> roomTypeDetailResponses = roomTypes.stream()
                .map(this::convertToRoomTypeDetailResponse)
                .collect(Collectors.toList());

        return new RoomTypesOfHotelResponse(hotel.getName(), hotel.getId(), roomTypeDetailResponses);
    }

    private RoomTypeDetailResponse convertToRoomTypeDetailResponse(RoomType roomType) {
        return RoomTypeDetailResponse.builder()
                .id(roomType.getId())
                .name(roomType.getName())
                .count(roomType.getCount())
                .price(roomType.getPrice())
                .bathroomCount(roomType.getBathroomCount())
                .roomArea(roomType.getRoomArea())
                .adultCount(roomType.getAdultCount())
                .childrenCount(roomType.getChildrenCount())
                .description(roomType.getDescription())
                .bedTypes(getBedTypes(roomType.getId()))
                .amenities(getAmenities(roomType.getId()))
                .view(getView(roomType.getId()))
                .images(getImagePaths(roomType.getId()))
                .rooms(getRoomNames(roomType.getId()))
                .build();
    }

    @Transactional
    public void updatePrice(Integer hotelId, Integer roomTypeId, Double newPrice) {
        RoomType roomType = roomTypeRepository.findByHotelIdAndId(hotelId, roomTypeId);
        roomType.setPrice(newPrice);
        roomTypeRepository.save(roomType);
    }

    public List<RoomAvailableResponse> getAvailableRooms(Integer hotelId, RoomAvailableRequest roomAvailableRequest) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new HotelNotFoundException("Hotel not found"));
        return roomTypeRepository.getAvailableRooms(hotelId, roomAvailableRequest.getStartDay(), roomAvailableRequest.getEndDay());
    }
}
