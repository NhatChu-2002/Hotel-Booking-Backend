package com.pbl6.hotelbookingapp.dto;

import com.pbl6.hotelbookingapp.entity.Hotel;
import com.pbl6.hotelbookingapp.entity.HotelHotelAmenity;
import com.pbl6.hotelbookingapp.entity.HotelImage;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Data
@NoArgsConstructor
public class HotelSearchResult {
    private Integer id;
    private String hotelName;
    private String address;
    private String hotelImgPath;
    private String amenity;
    private Double ratingTotal;
    private Double price;

    public HotelSearchResult(Integer id,String hotelName, String address, String hotelImgPath, String amenity, Double ratingTotal, Double price) {
        this.id = id;
        this.hotelName = hotelName;
        this.address = address;
        this.hotelImgPath = hotelImgPath;
        this.amenity = amenity;
        this.ratingTotal = ratingTotal;
        this.price = price;
    }

}







