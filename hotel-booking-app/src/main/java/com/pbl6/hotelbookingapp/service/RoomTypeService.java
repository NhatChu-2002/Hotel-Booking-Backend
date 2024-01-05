package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.dto.*;
import com.pbl6.hotelbookingapp.entity.RoomAmenity;
import com.pbl6.hotelbookingapp.entity.RoomType;
import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoomTypeService {
    Optional<RoomType> findRoomTypeByIdAndHotelId(Integer id, Integer hotelId);

    @Transactional
    AddRoomTypeResponse addRoomType(Integer hotelId, RoomTypeDTO roomTypeDTO) throws IOException;

    @Transactional
    void updateRoomType(Integer hotelId, Integer roomTypeId, RoomTypeDTO roomTypeDTO) throws IOException;

    void updateRoomType(RoomType roomType, RoomTypeDTO roomTypeDTO);

    Set<RoomAmenity> updateRoomAmenities(RoomType roomType, List<String> amenityNames);

    void updateRoomBedTypes(RoomType roomType, List<BedTypeDTO> bedTypes);

    void updateRoomImages(RoomType roomType, List<MultipartFile> images) throws IOException;

    @Transactional
    void deleteRoomTypeById(Integer hotelId, Integer roomTypeId);

    RoomTypeDetailResponse findRoomTypeById(Integer hotelId, Integer roomTypeId);

    List<String> getImagePaths(Integer roomTypeId);

    List<String> getAmenities(Integer roomTypeId);

    List<String> getRoomNames(Integer roomTypeId);

    String getView(Integer roomTypeId);

    List<BedTypeDTO> getBedTypes(Integer roomTypeId);

    RoomTypesOfHotelResponse findRoomTypesByHotelId(Integer hotelId);

    RoomTypeDetailResponse convertToRoomTypeDetailResponse(RoomType roomType);

    @Transactional
    void updatePrice(Integer hotelId, Integer roomTypeId, Double newPrice);

    List<RoomAvailableResponse> getAvailableRooms(Integer hotelId, RoomAvailableRequest roomAvailableRequest);

    List<RoomTypeDetailResponse> searchRoomTypesByName(Integer hotelId, String name);

}
