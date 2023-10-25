package com.pbl6.hotelbookingapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="payment_type")
@Getter
@Setter
public class PaymentType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="payment_type_name")
    private String paymentTypeName;

    @OneToMany(mappedBy = "paymentType", cascade = CascadeType.ALL)
    private Set<Invoice> invoices = new HashSet<>();
}
