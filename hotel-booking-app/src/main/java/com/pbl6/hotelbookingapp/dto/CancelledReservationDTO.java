package com.pbl6.hotelbookingapp.dto;

import com.pbl6.hotelbookingapp.entity.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CancelledReservationDTO {
    private String reservationCode;
    private String hotelName;
    private LocalDateTime timePaid;
    private Double paidAmount;
    private LocalDateTime timeCancelled;
    private long refundAmount;
    private String address;
    private String imagePath;
    private ReservationStatus status;

}
