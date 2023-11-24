package com.pbl6.hotelbookingapp.dto;

import com.pbl6.hotelbookingapp.entity.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponse {
    private Integer userId;
    private String reservationCode;
    private String hotelName;
    private String province;
    private String address;
    private List<RoomTypesResponse> roomList;
    private Double total;
    private LocalDate startDay;
    private LocalDate endDay;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;
    private String description;
    private ReservationStatus status;
}
