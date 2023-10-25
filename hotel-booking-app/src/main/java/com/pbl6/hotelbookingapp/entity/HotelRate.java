package com.pbl6.hotelbookingapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="hotel_rate")
@Getter
@Setter
public class HotelRate {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @OneToMany(mappedBy = "hotelRate", cascade = CascadeType.ALL)
    private Set<Hotel> hotels = new HashSet<>();

}
