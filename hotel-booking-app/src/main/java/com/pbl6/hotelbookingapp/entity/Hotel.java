package com.pbl6.hotelbookingapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="hotel")
@Getter
@Setter
public class Hotel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="rule")
    private String rule;
    @Column(name="province")
    private String province;
    @Column(name="district")
    private String district;
    @Column(name="ward")
    private String ward;
    @Column(name="street")
    private String street;
    @Column(name="main_phone_number")
    private String mainPhoneNumber;
    @Column(name="main_email")
    private String mainEmail;
    @Column(name="check_in_time")
    private LocalTime checkInTime;
    @Column(name="check_out_time")
    private LocalTime checkOutTime;
    @Column(name="created_at")
    @CreationTimestamp
    private Date createdAt;
    @Column(name="modified_at")
    @UpdateTimestamp
    private Date modifiedAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "rate_id")
    private HotelRate hotelRate;

    @Enumerated(EnumType.STRING)
    private HotelStatus status;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<ExtraService> extraServices = new HashSet<>();

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<HotelService> hotelServices = new HashSet<>();
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Room> rooms = new HashSet<>();
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Review> reviews = new HashSet<>();
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<HotelImage> hotelImages = new HashSet<>();
}
