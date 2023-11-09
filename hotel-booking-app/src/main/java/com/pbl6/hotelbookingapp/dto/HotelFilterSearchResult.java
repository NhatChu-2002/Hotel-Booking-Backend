package com.pbl6.hotelbookingapp.dto;

import com.pbl6.hotelbookingapp.entity.Hotel;
import com.pbl6.hotelbookingapp.entity.HotelHotelAmenity;
import com.pbl6.hotelbookingapp.entity.HotelImage;
import com.pbl6.hotelbookingapp.entity.RoomType;
import lombok.*;

import java.util.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelFilterSearchResult {
    private Integer id;
    private String hotelName;
    private String address;
    private String hotelImgPath;
    private Set<String> amenities;
    private Long reviews;
    private Double rating;
    private Double minPrice;
    private Double maxPrice;


    public static HotelFilterSearchResult fromHotel(Hotel hotel) {
        HotelFilterSearchResult result = new HotelFilterSearchResult();
        result.setId(hotel.getId());
        result.setHotelName(hotel.getName());
        result.setAddress(hotel.getStreet() + ", " + hotel.getWard() + ", " + hotel.getDistrict() + ", " + hotel.getProvince());

        Set<HotelImage> hotelImages = hotel.getHotelImages();
        if (hotelImages != null && !hotelImages.isEmpty()) {
            HotelImage firstImage = hotelImages.iterator().next();
            result.setHotelImgPath(firstImage.getImagePath());
        }

        Set<String> amenities = new HashSet<>();
        for (HotelHotelAmenity hotelAmenity : hotel.getHotelHotelAmenities()) {
            amenities.add(hotelAmenity.getHotelAmenity().getName());
        }
        result.setAmenities(amenities);



        Set<RoomType> roomTypes = hotel.getRoomTypes();
        if (roomTypes != null && !roomTypes.isEmpty()) {
            Optional<RoomType> minPriceRoomType = roomTypes.stream()
                    .min(Comparator.comparing(RoomType::getPrice));
            result.setMinPrice(minPriceRoomType.map(RoomType::getPrice).orElse(null));

            Optional<RoomType> maxPriceRoomType = roomTypes.stream()
                    .max(Comparator.comparing(RoomType::getPrice));
            result.setMaxPrice(maxPriceRoomType.map(RoomType::getPrice).orElse(null));
        }
        result.setRating(hotel.getAverageRating());
        Long numReviews = Long.valueOf(hotel.getReviews().size());
        result.setReviews(numReviews);


        return result;
    }
}
