package com.pbl6.hotelbookingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveInvoiceRequest {
        Integer userId;
        Integer reservationId;
        String orderId;
        Double price;
        String transDate;

}
