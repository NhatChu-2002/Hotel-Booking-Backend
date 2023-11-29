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
@Table(name="room_amenity")
@Getter
@Setter
public class RoomAmenity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="created_at")
    @CreationTimestamp
    private Date createdAt;
    @Column(name="modified_at")
    @UpdateTimestamp
    private Date modifiedAt;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name="room_room_amenity",
            joinColumns = @JoinColumn(name="room_amenity_id"),
            inverseJoinColumns = @JoinColumn(name="room_type_id"))
    @JsonIgnore
    private Set<RoomType> roomTypes = new HashSet<>();

    public RoomAmenity(String name) {
        this.name = name;
    }

    public RoomAmenity() {

    }
}
