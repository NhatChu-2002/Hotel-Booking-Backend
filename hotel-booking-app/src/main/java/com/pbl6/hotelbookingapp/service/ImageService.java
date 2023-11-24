package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.Exception.HotelNotFoundException;
import com.pbl6.hotelbookingapp.Exception.RoomTypeNotFoundException;
import com.pbl6.hotelbookingapp.entity.Hotel;
import com.pbl6.hotelbookingapp.entity.HotelImage;
import com.pbl6.hotelbookingapp.entity.RoomImage;
import com.pbl6.hotelbookingapp.entity.RoomType;
import com.pbl6.hotelbookingapp.repository.HotelImageRepository;
import com.pbl6.hotelbookingapp.repository.HotelRepository;
import com.pbl6.hotelbookingapp.repository.RoomImageRepository;
import com.pbl6.hotelbookingapp.repository.RoomTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageService {

    private HotelRepository hotelRepository;

    private RoomTypeRepository roomTypeRepository;

    private HotelImageRepository imageRepository;

    private FirebaseStorageService firebaseStorageService;

    private RoomImageRepository roomImageRepository;

    public ImageService(HotelRepository hotelRepository, RoomTypeRepository roomTypeRepository, HotelImageRepository imageRepository, FirebaseStorageService firebaseStorageService, RoomImageRepository roomImageRepository) {
        this.hotelRepository = hotelRepository;
        this.roomTypeRepository = roomTypeRepository;
        this.imageRepository = imageRepository;
        this.firebaseStorageService = firebaseStorageService;
        this.roomImageRepository = roomImageRepository;
    }

    @Transactional
    public void uploadHotelImage(Integer hotelId, List<MultipartFile> images) throws IOException {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new HotelNotFoundException("Hotel not found"));
        imageRepository.deleteByHotel(hotel);

        List<String> imageUrls = firebaseStorageService.saveImages(images);
        for (String imageUrl : imageUrls) {
            HotelImage image = new HotelImage();
            image.setHotel(hotel);
            image.setImagePath(imageUrl);
            imageRepository.save(image);
        }
    }

    @Transactional
    public void uploadRoomTypeImage(Integer roomTypeId, List<MultipartFile> images) throws IOException {
        RoomType roomType = roomTypeRepository.findById(roomTypeId).orElseThrow(() -> new RoomTypeNotFoundException("Room Type not found"));
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
