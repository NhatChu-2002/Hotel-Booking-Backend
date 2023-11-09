package com.pbl6.hotelbookingapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomSearchResult {
    private List<HotelFilterSearchResult> hotels;
    private Long totalItems;
    private String location;
}
