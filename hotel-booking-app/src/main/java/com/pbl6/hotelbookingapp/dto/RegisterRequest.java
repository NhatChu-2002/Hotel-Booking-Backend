package com.pbl6.hotelbookingapp.dto;

import com.pbl6.hotelbookingapp.entity.Role;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String fullName;
    @Email(message = "invalid email address")
    private String email;
    @NotNull(message = "username shouldn't be null")
    private String password;
    private Role role;
}
