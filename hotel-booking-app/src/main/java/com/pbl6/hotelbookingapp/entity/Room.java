package com.pbl6.hotelbookingapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @Column(name="description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<RoomReserved> roomReserved = new HashSet<>();
}
