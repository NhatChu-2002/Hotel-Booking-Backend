package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.dto.AuthenticationRequest;
import com.pbl6.hotelbookingapp.dto.AuthenticationResponse;
import com.pbl6.hotelbookingapp.dto.RegisterRequest;
import com.pbl6.hotelbookingapp.dto.RegisterResponse;
import com.pbl6.hotelbookingapp.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthenticationService {
    RegisterResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    void revokeAllUserTokens(User user);

    void saveUserToken(User user, String jwtToken);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
