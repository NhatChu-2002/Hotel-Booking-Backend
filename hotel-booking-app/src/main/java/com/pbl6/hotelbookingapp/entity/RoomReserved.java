package com.pbl6.hotelbookingapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Reservation reservation;
    @Column(name="start_day")
    private Date startDay;
    @Column(name="end_day")
    private Date endDay;
    @ManyToOne
    @JoinColumn(name="room_id")
    @JsonIgnore
    private Room room;

}
