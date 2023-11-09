package com.pbl6.hotelbookingapp.dto;

import com.pbl6.hotelbookingapp.entity.Hotel;
import com.pbl6.hotelbookingapp.entity.HotelHotelAmenity;
import com.pbl6.hotelbookingapp.entity.HotelImage;
import lombok.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelSearchResult {
    private Integer hotelId;
    private String hotelName;
    private String address;
    private String hotelImgPath;
    private String amenity;
    private Double ratingTotal;
    private Long reviews;
    private Double minPrice;
    private Double maxPrice;

    public Set<String> getAmenitiesSet() {
        if (amenity != null && !amenity.isEmpty()) {
            return new HashSet<>(Arrays.asList(amenity.split(",")));
        }
        return Collections.emptySet();

    }

}







