package com.pbl6.hotelbookingapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Entity
@Table(name="room_reserved")
@Getter
@Setter
public class RoomReserved {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name="reservation_id")
    private Reservation reservation;
    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;
    @Column(name="price_per_day")
    private Double pricePerDay;

}
