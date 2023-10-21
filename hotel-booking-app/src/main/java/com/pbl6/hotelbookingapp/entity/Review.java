package com.pbl6.hotelbookingapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Entity
@Table(name="review")
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="hotel_id")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="cleanliness_rating")
    private Double cleanlinessRating;
    @Column(name="location_rating")
    private Double locationRating;
    @Column(name="staff_rating")
    private Double staffRating;
    @Column(name="comment")
    private String comment;

}
