package com.pbl6.hotelbookingapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pbl6.hotelbookingapp.Exception.UserNotFoundException;
import com.pbl6.hotelbookingapp.dto.AuthenticationRequest;
import com.pbl6.hotelbookingapp.dto.AuthenticationResponse;
import com.pbl6.hotelbookingapp.dto.RegisterRequest;
import com.pbl6.hotelbookingapp.dto.RegisterResponse;
import com.pbl6.hotelbookingapp.entity.*;
import com.pbl6.hotelbookingapp.repository.HotelRepository;
import com.pbl6.hotelbookingapp.repository.TokenRepository;
import com.pbl6.hotelbookingapp.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository repository;
    private final UserService userService;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final HotelRepository hotelRepository;

    @Override
    public RegisterResponse register(RegisterRequest request) {
        Optional<User> checkUser = repository.findByEmail(request.getEmail());
        var jwtToken = new String();
        var refreshToken = new String();
        if (checkUser.isPresent() && !checkUser.get().isDeleted()){
            if(checkUser.get().getRole()== Role.CUSTOMER || checkUser.get().getRole()== Role.ADMIN || checkUser.get().getRole()== Role.HOST  )
            {
                throw new UserNotFoundException(
                        "User with email "+request.getEmail() + " already exists");
            }else if (checkUser.get().getRole() == Role.NOT_REGISTERED_CUSTOMER){

                userService.editNotRegisteredUser(checkUser.get().getId(),request.getFullName(), passwordEncoder.encode(request.getPassword()),Role.CUSTOMER);
                jwtToken = jwtService.generateToken(checkUser.get());
                refreshToken = jwtService.generateRefreshToken(checkUser.get());
                saveUserToken(checkUser.get(), jwtToken);

            }

        }
        else {
            var user = new User();
            user = User.builder()
                    .fullName(request.getFullName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.CUSTOMER)
                    .isDeleted(false)
                    .build();
            var savedUser = repository.save(user);

            jwtToken = jwtService.generateToken(user);
            refreshToken = jwtService.generateRefreshToken(user);

            saveUserToken(savedUser, jwtToken);
//            emailService.sendHtmlEmail(savedUser.getFullName(), savedUser.getEmail(), jwtToken);


        }

        return RegisterResponse.builder().accessToken(jwtToken)
                .refreshToken(refreshToken).build();

    }




    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Optional<User> checkUser = repository.findByEmail(request.getEmail());
        if (!checkUser.isPresent() || checkUser.get().isDeleted()){
            throw new UserNotFoundException(
                    "User not found:  "+request.getEmail());
        }
        else if(checkUser.get().getRole() == Role.NOT_REGISTERED_CUSTOMER){
            throw new UserNotFoundException(
                    "Email not registered or not verified!:  "+request.getEmail());
        }
        else{
            User user = checkUser.get();
            if(!passwordEncoder.matches(request.getPassword(), user.getPassword()))
            {
                throw new UserNotFoundException(
                        "Wrong password! ");
            }
            else{
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()
                        )
                );

                var id = user.getId();
                var role = user.getRole();
                var jwtToken = jwtService.generateToken(user);
                var refreshToken = jwtService.generateRefreshToken(user);

                revokeAllUserTokens(user);
                saveUserToken(user, jwtToken);
                return AuthenticationResponse
                        .builder()
                        .accessToken(jwtToken)
                        .refreshToken(refreshToken)
                        .id(id)
                        .role(String.valueOf(role))
                        .name(user.getFullName())
                        .email(user.getEmail())
                        .build();
            }
        }

    }
    @Override
    public void revokeAllUserTokens(User user)
    {
        var validUserTokens = tokenRepository.findAllValidTokensByUser(user.getId());
        if(validUserTokens.isEmpty())
        {
            return;
        }
        validUserTokens.forEach(t -> {
            t.setExpired(true);
            t.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);

    }
    @Override
    public void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();
        tokenRepository.save(token);
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;

        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUserName(refreshToken); //extract user email from JWT token;

        if(userEmail != null)
        {
            var user = this.repository.findByEmail(userEmail).orElseThrow();

            if(jwtService.isTokenValid(refreshToken, user)){
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var refreshResponse = RegisterResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), refreshResponse);
            }
        }
    }
}
