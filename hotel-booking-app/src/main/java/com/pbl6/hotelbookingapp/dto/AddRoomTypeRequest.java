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
    private String name;
    private Integer count;
    private Double price;
    private Integer bathroom_count;
    private Integer room_area;
    private Integer adult_count;
    private Integer children_count;
    private String description;
    private List<BedTypeDTO> bedTypes;
    private List<String> amenities;
    private String view;
    private List<MultipartFile> images;
}
