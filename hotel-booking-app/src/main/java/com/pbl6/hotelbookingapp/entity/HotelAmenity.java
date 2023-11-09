package com.pbl6.hotelbookingapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="hotel_amenity")
@Getter
@Setter
public class HotelAmenity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
//    @ManyToOne
//    @JoinColumn(name = "hotel_id")
//    private Hotel hotel;
    @Column(name="created_at")
    @CreationTimestamp
    private Date createdAt;
    @Column(name="modified_at")
    @UpdateTimestamp
    private Date modifiedAt;
//    @OneToMany(mappedBy = "hotelAmenity", cascade = CascadeType.ALL)
//    @JsonIgnore
//    private Set<HotelHotelAmenity> hotelHotelAmenities = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name="hotel_hotel_amenity",
            joinColumns = @JoinColumn(name="hotel_amenity_id"),
            inverseJoinColumns = @JoinColumn(name="hotel_id"))
    private Set<Hotel> hotels = new HashSet<>();
}
