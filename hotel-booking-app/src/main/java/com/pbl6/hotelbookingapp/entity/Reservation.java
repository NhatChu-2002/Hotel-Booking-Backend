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
    @Column(name = "reservation_code")
    private String reservationCode;
    @Column(name = "email")
    private String email;
    @Column(name = "site_fees")
    private Double siteFee;
    @Column(name = "tax_paid")
    private Double taxPaid;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;
    @Column(name = "modified_at")
    @UpdateTimestamp
    private Date modifiedAt;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Invoice invoice;
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<RoomReserved> roomReserved = new HashSet<>();

}
