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
public class RoomTypesOfHotelResponse {
    private String hotelName;
    private Integer hotelId;
    private List<RoomTypeDetailResponse> roomTypes;
}
