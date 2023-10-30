package com.pbl6.hotelbookingapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="room")
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="price")
    private Double price;
    @Column(name="bathroom_count")
    private Long bathroomCount;
    @Column(name="adult_count")
    private Long adultCount;
    @Column(name="children_count")
    private Long childrenCount;
    @Column(name="room_area")
    private Double roomArea;
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
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
    @ManyToOne
    @JoinColumn(name = "view_id")
    private View view;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<RoomAvailability> roomAvailabilities = new HashSet<>();
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<RoomReserved> roomReserved = new HashSet<>();
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<RoomImage> roomImages = new HashSet<>();

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<RoomBedType> roomBedTypes = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name="room_amenity",
            joinColumns = @JoinColumn(name="room_id"),
            inverseJoinColumns = @JoinColumn(name="amenity_id"))
    private Set<Amenity> amenities = new HashSet<>();

}
