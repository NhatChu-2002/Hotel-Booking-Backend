package com.pbl6.hotelbookingapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Entity
@Table(name="hotel_image")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelImage {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="hotel_id")
    private Hotel hotel;
    @Column(name="image_path")
    private String imagePath;
    @Column(name="created_at")
    @CreationTimestamp
    private Date createdAt;
    @Column(name="modified_at")
    @UpdateTimestamp
    private Date modifiedAt;
}