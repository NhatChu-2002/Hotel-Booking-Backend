package com.pbl6.hotelbookingapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomSearchResult {
    private List<HotelSearchResult> hotels;
    private Long totalItems;
}
