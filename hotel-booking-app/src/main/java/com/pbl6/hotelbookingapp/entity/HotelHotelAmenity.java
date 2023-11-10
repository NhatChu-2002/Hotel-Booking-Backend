package com.pbl6.hotelbookingapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="hotel_hotel_amenity")
@IdClass(HotelHotelAmenityId.class)
@Getter
@Setter
public class HotelHotelAmenity {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_amenity_id")
    private HotelAmenity hotelAmenity;
    @Column(name="price")
    private Double price;
}
