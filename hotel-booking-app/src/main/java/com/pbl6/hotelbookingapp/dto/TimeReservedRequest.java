package com.pbl6.hotelbookingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeReservedRequest {
    private LocalDate startDay;
    private LocalDate endDay;
}
