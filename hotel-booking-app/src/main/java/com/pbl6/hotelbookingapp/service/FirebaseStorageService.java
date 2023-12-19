package com.pbl6.hotelbookingapp.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface FirebaseStorageService {
    List<String> saveImages(List<MultipartFile> images) throws IOException;

    default String generateUniqueImageName(MultipartFile image) {
        return UUID.randomUUID().toString() + "_" + image.getOriginalFilename();
    }
}
