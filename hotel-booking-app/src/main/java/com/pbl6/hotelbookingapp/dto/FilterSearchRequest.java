package com.pbl6.hotelbookingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilterSearchRequest {
    private List<Integer> hotelIds;
    private String rate;
    private Double fromPrice;
    private Double toPrice;
    private Double review;
}
