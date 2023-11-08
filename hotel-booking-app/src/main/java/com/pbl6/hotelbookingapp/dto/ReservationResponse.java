package com.pbl6.hotelbookingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponse {
    private String hotelName;
    private String province;
    private String address;
    private String roomType;
    private Integer count;
    private Double total;
    private LocalDate startDay;
    private LocalDate endDay;
}
