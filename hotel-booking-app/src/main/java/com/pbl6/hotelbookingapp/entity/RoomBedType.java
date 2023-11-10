package com.pbl6.hotelbookingapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="room_bed_type")
@IdClass(RoomBedTypeId.class)
@Getter
@Setter
public class RoomBedType {
    @Id
    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
    @Id
    @ManyToOne
    @JoinColumn(name = "bed_type_id")
    private BedType bedType;
    @Column(name="count")
    private Integer count;
}
