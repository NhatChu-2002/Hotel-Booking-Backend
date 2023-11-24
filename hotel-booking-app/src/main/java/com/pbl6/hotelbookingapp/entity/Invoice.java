package com.pbl6.hotelbookingapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
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
    @JsonIgnore
    private User user;
    @Column(name = "invoice_amount")
    private Double invoiceAmount;
    @Column(name = "refund_amount")
    private long refundAmount;
    @Column(name = "time_created")
    @CreationTimestamp
    private Date timeCreated;
    @Column(name = "time_paid")
    private LocalDateTime timePaid;
    @Column(name = "time_canceled")
    private LocalDateTime timeCanceled;
    @Column(name = "vnp_txnref")
    private String vnpRef;
    @Column(name = "vnp_transdate")
    private String vnpTransdate;
    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "reservation_id", referencedColumnName = "id")
    @JsonIgnore
    private Reservation reservation;

}
