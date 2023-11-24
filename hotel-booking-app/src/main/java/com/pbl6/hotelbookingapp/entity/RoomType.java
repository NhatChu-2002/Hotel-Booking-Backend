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
@Table(name="room_type")
@Getter
@Setter
public class RoomType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name = "count")
    private Integer count;
    @Column(name="price")
    private Double price;
    @Column(name="bathroom_count")
    private Integer bathroomCount;
    @Column(name="adult_count")
    private Integer adultCount;
    @Column(name="children_count")
    private Integer childrenCount;
    @Column(name="room_area")
    private Integer roomArea;
    @Column(name="description")
    private String description;
    @Column(name="created_at")
    @CreationTimestamp
    private Date createdAt;
    @Column(name="modified_at")
    @UpdateTimestamp
    private Date modifiedAt;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "view_id")
    @JsonIgnore
    private View view;
    @OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Room> rooms = new HashSet<>();
    @OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<RoomImage> roomImages = new HashSet<>();
    @OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<RoomBedType> roomBedTypes = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name="room_room_amenity",
            joinColumns = @JoinColumn(name="room_type_id"),
            inverseJoinColumns = @JoinColumn(name="room_amenity_id"))
    @JsonIgnore
    private Set<RoomAmenity> amenities = new HashSet<>();

}
