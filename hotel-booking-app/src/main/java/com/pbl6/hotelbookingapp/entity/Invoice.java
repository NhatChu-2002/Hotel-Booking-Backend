package com.pbl6.hotelbookingapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name="invoice")
@Getter
@Setter
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "invoice_amount")
    private Double invoiceAmount;
    @Column(name = "refund_amount")
    private Double refundAmount;
    @Column(name = "time_created")
    @CreationTimestamp
    private Date timeCreated;
    @Column(name = "time_paid")
    private Date timePaid;
    @Column(name = "time_canceled")
    private Date timeCanceled;
    @ManyToOne
    @JoinColumn(name = "payment_types_id")
    private PaymentType paymentType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "reservation_id", referencedColumnName = "id")
    private Reservation reservation;

}
