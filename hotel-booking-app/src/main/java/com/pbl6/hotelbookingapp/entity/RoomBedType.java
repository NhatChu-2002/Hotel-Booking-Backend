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
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
    @Id
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "bed_type_id")
    private BedType bedType;
    @Column(name="count")
    private Integer count;
}
