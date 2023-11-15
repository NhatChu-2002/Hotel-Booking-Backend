package com.pbl6.hotelbookingapp.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddRoomTypeRequest {
    private Integer hotelId;
    private String name;
    private String roomName;
    private Integer count;
    private Double price;
    private Integer bathroomCount;
    private Integer roomArea;
    private Integer adultCount;
    private Integer childrenCount;
    private String description;
    private List<BedTypeDTO> bedTypes;
    private List<String> amenities;
    private String view;
    private List<MultipartFile> images;
}
