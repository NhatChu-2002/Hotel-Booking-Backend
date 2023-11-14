package com.pbl6.hotelbookingapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {
    private Integer hotelId;
    private String roomType;
    private String email;
    private Integer count;
    private Double price;

    private LocalDate startDay;
    private LocalDate endDay;
}
