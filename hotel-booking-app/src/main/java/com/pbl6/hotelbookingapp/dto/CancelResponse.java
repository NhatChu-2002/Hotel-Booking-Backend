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
public class CancelResponse {
    String reservationCode;
    String hotelName;
    String cancelDate;
    String amount;
    Double refundAmount;
    String orderId;
}
