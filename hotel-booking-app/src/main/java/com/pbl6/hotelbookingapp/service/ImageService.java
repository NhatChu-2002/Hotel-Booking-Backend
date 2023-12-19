package com.pbl6.hotelbookingapp.service;

import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    @Transactional
    void uploadHotelImage(Integer hotelId, List<MultipartFile> images) throws IOException;

    @Transactional
    void uploadRoomTypeImage(Integer roomTypeId, List<MultipartFile> images) throws IOException;
}
