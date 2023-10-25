package com.pbl6.hotelbookingapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="room_availability")
@Getter
@Setter
public class RoomAvailability {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="start_day")
    private Date startDay;
    @Column(name="end_day")
    private Date endDay;
    @Column(name="status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
