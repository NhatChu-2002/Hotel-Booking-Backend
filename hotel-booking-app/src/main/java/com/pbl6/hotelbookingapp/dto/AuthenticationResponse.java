package com.pbl6.hotelbookingapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pbl6.hotelbookingapp.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("role")
    private String role;
    @JsonProperty("email")
    private String email;
    @JsonProperty("name")
    private String name;

}
