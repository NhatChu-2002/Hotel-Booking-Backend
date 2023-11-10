package com.pbl6.hotelbookingapp.dto;

import com.pbl6.hotelbookingapp.entity.ExtraService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelDetails {
    private Integer id;
    private String hotelName;
    private String address;
    private LocalTime checkIn;
    private LocalTime checkOut;
    private double minPrice;
    private String description;
    private List<String> hotelImages;
    private List<String> hotelAmenities;
    private List<ExtraService> extraServices;
    private List<RoomTypeDetails> roomList;
    private List<ReviewDTO> reviews;
    private  List<String> rules;
}
