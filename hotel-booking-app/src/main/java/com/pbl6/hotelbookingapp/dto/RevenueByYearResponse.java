package com.pbl6.hotelbookingapp.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevenueByYearResponse {
    private Integer year;
    @JsonSerialize(using = DecimalJsonSerializer.class)
    private Double revenue;
}

