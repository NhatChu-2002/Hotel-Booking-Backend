package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.entity.FileData;
import com.pbl6.hotelbookingapp.repository.FileDataRepository;
import com.pbl6.hotelbookingapp.repository.StorageRepository;
import com.pbl6.hotelbookingapp.entity.ImageData;
import com.pbl6.hotelbookingapp.util.ImageUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class StorageService {
    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
    private StorageRepository repository;

    private FileDataRepository fileDataRepository;

    public StorageService(StorageRepository theRepository, FileDataRepository fileRepository){
        this.repository = theRepository;
        this.fileDataRepository = fileRepository;
    };


    public String uploadImage(MultipartFile file) throws IOException {

        ImageData imageData = repository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData = repository.findByName(fileName);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
    public String uploadImageToResource(MultipartFile file) throws IOException {

        String filePath=CURRENT_FOLDER+"/src/main/resources/static/images/"+file.getOriginalFilename();
        Optional<FileData> existingFileData = fileDataRepository.findByName(file.getOriginalFilename());

        if (!existingFileData.isEmpty()) {

            return "file or file_name already exists";
        }
        FileData fileData=fileDataRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }
    public byte[] downloadImageFromResource(String fileName) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
        String filePath=fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }
}


