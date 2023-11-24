package com.pbl6.hotelbookingapp.dto;

import com.pbl6.hotelbookingapp.entity.HotelStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelAdminResponse {
    String hotelName;
    HotelStatus status;
}
