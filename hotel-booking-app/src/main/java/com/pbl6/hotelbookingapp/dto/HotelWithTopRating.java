package com.pbl6.hotelbookingapp.dto;

import lombok.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class HotelWithTopRating {
    private String imagePath;
    private String name;
    private String address;
    private Double rating;
    private Long totalReviews;


    public HotelWithTopRating(String imagePath, String name, String address, Double rating, Long totalReviews) {
        this.imagePath = imagePath;
        this.name = name;
        this.address = address;
        this.rating = Math.round(rating * 100.0) / 100.0;
        this.totalReviews = totalReviews;
    }
}
