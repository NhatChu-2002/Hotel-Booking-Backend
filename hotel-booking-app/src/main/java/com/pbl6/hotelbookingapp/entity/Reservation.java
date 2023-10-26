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
@Table(name="reservation")
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "email")
    private String email;
    @Column(name = "start_day")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;
    @Column(name = "modified_at")
    @UpdateTimestamp
    private Date modifiedAt;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Invoice invoice;
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Set<ReservationStatusEvent> reservationStatusEvents = new HashSet<>();
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Set<RoomReserved> roomReserved = new HashSet<>();

}