package com.pbl6.hotelbookingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilterSearchRequest {
    private String province;
    private LocalDate checkinDay;
    private LocalDate checkoutDay;
    private int count;
    private int adultCount;
    private int childrenCount;
    private String rate;
    private Double fromPrice;
    private Double toPrice;
    private Double review;
    private int pageIndex;
    private int pageSize;
}
