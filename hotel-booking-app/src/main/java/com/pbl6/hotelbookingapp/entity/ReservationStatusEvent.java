package com.pbl6.hotelbookingapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name="reservation_status_event")
@Getter
@Setter
public class ReservationStatusEvent {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="reservation_id")
    private Reservation reservation;
    @ManyToOne
    @JoinColumn(name="reservation_status_id")
    private ReservationStatus reservationStatus;

    @Column(name="details")
    private String details;
    @Column(name="created_at")
    @CreationTimestamp
    private Date createdAt;
    @Column(name="modified_at")
    @UpdateTimestamp
    private Date modifiedAt;
}
