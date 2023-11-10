package com.pbl6.hotelbookingapp.dto;

import com.pbl6.hotelbookingapp.entity.HotelStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalTime;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddHotelRequest {
    private String name;
    private String description;
    private String province;
    private String district;
    private String ward;
    private String street;
    private String mainPhoneNumber;
    private String mainEmail;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;
    private HotelStatus status;
    private List<String> rules;
    private List<AmenityPriceDTO> amenities;
    private Integer rate;
    private List<MultipartFile> images;
}
