package com.pbl6.hotelbookingapp.entity;

import java.io.Serializable;
import java.util.Objects;


public class HotelHotelAmenityId implements Serializable {
    private Integer hotel;
    private Integer hotelAmenity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelHotelAmenityId that = (HotelHotelAmenityId) o;
        return Objects.equals(hotel, that.hotel) && Objects.equals(hotelAmenity, that.hotelAmenity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotel, hotelAmenity);
    }



}
