package com.pbl6.hotelbookingapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {
    private Integer hotelId;
    private String note;
    private String name;
    @Email(message = "invalid email address")
    private String email;
    private String phoneNumber;
    private String paymentMethod;
    private List<RoomTypeReserved> roomTypeReservedList;
    private Double totalPrice;
    private String orderId;
    private String transDate;
    private Double tax;
    private Double vat;
    private LocalDate startDay;
    private LocalDate endDay;
}
