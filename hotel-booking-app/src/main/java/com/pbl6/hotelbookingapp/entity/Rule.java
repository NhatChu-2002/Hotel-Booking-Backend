package com.pbl6.hotelbookingapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="rule")
@Getter
@Setter
public class Rule {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name="hotel_rule",
            joinColumns = @JoinColumn(name="rule_id"),
            inverseJoinColumns = @JoinColumn(name="hotel_id"))
    private Set<Hotel> hotels = new HashSet<>();

}
