package com.pbl6.hotelbookingapp.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.common.io.ByteStreams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FirebaseStorageService {

    @Value("${firebase.storage.bucket-name}")
    private String bucketName;

    @Value("classpath:serviceAccountKey.json")
    private Resource resource;

    public List<String> saveImages(List<MultipartFile> images) throws IOException {
        List<String> imagePaths = new ArrayList<>();

        try (InputStream serviceAccountStream = resource.getInputStream()) {
            // Initialize Storage using the loaded service account credentials
            StorageOptions storageOptions = StorageOptions.newBuilder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccountStream))
                    .build();
            Storage storage = storageOptions.getService();

            for (MultipartFile image : images) {
                try {
                    String imageName = generateUniqueImageName(image);
                    String storagePath = "images/" + imageName;

                    // Upload image to Firebase Storage
                    BlobId blobId = BlobId.of(bucketName, storagePath);
                    BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                            .setContentType(image.getContentType())
                            .build();
                    byte[] bytes = ByteStreams.toByteArray(image.getInputStream());
                    storage.create(blobInfo, bytes);

                    String imageUrl = String.format("https://storage.googleapis.com/%s/%s", bucketName, storagePath);
                    imagePaths.add(imageUrl);
                } catch (StorageException | IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Failed to upload image to Firebase Storage");
                }
            }
        }

        return imagePaths;
    }

    private String generateUniqueImageName(MultipartFile image) {
        return UUID.randomUUID().toString() + "_" + image.getOriginalFilename();
    }
}
