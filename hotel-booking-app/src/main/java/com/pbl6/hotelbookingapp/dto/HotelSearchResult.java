package com.pbl6.hotelbookingapp.dto;

import lombok.*;
@Getter
@Setter
@Data
public class HotelSearchResult {
    private String hotelName;
    private String address;
    private String hotelImgPath;
    private String amenity;
    private Double ratingTotal;
    private Double price;

    public HotelSearchResult(String hotelName, String address, String hotelImgPath, String amenity, Double ratingTotal, Double price) {
        this.hotelName = hotelName;
        this.address = address;
        this.hotelImgPath = hotelImgPath;
        this.amenity = amenity;
        this.ratingTotal = ratingTotal;
        this.price = price;
    }
}






