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
    private Integer id;
    @ManyToOne
    @JoinColumn(name="hotel_id")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
<<<<<<< HEAD

    @Column(name="rating_total")
    private Integer rating;
=======
    @Column(name="rating_total")
    private Double ratingTotal;
>>>>>>> 19689a4420e4a29f5d912ac8a9a82a0e05cb0258
    @Column(name="comment")
    private String comment;

}
