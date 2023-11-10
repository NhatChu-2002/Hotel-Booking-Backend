package com.pbl6.hotelbookingapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
    @JsonIgnore
    private User user;
    @ManyToOne
    @JoinColumn(name = "rate_id")
    @JsonIgnore
    private HotelRate hotelRate;
    @Enumerated(EnumType.STRING)
    private HotelStatus status;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ExtraService> extraServices = new HashSet<>();
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<HotelHotelAmenity> hotelHotelAmenities = new HashSet<>();
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<RoomType> roomTypes = new HashSet<>();
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Review> reviews = new HashSet<>();
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<HotelImage> hotelImages = new HashSet<>();
    public Double getAverageRating() {
        Set<Review> reviews = getReviews();
        return calculateAverageRating(reviews);
    }
    public Double calculateAverageRating(Set<Review> reviews) {
        if (reviews == null || reviews.isEmpty()) {
            return null;
        }

        double totalRating = 0.0;
        for (Review review : reviews) {
            totalRating += review.getRatingTotal();
        }

        return Math.round((totalRating / reviews.size()) * 10) / 10.0;
    }


}
