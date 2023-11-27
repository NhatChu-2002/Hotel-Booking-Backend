package com.pbl6.hotelbookingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservedHistoryResponse {
    private List<ReservationDto> reservationList;
    private List<CancelledReservationDTO> cancelList;
    private int totalReservation;
    private int totalCancel;
}
