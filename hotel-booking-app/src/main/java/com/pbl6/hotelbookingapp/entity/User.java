package com.pbl6.hotelbookingapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="full_name")
    private String fullName;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="date_of_birth")
    private Date dateOfBirth;
    @Column(name="gender")
    private Integer gender;
    @Column(name="created_at")
    @CreationTimestamp
    private Date createdAt;
    @Column(name="modified_at")
    @UpdateTimestamp
    private Date modifiedAt;
    @Column(name="expire_time")
    private Date expireTime;
    @Column(name="otp")
    private String otp;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Token> tokens;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Invoice> invoices = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Review> reviews = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
