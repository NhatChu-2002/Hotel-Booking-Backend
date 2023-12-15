package com.pbl6.hotelbookingapp.dto;

import com.pbl6.hotelbookingapp.entity.HotelAmenity;
import com.pbl6.hotelbookingapp.entity.RoomAmenity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AmenitySearchResponse {
    private List<HotelAmenity> hotelAmenities;
    private List<RoomAmenity> roomAmenities;
}
