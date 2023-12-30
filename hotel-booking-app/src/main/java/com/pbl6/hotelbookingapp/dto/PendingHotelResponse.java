package com.pbl6.hotelbookingapp.dto;

import com.pbl6.hotelbookingapp.entity.Hotel;
import com.pbl6.hotelbookingapp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PendingHotelResponse {
    User host;
    Hotel hotel;
}
