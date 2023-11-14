package com.pbl6.hotelbookingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomTypeDetails {
    private Integer id;
    private String roomName;
    private Double price;
    private String roomImage;
    private Integer quantity;
    private Integer adult;
    private Integer children;
    private List<String> roomAmenities;

}
