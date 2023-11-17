package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.Exception.ResponseException;
import com.pbl6.hotelbookingapp.Exception.UserNotFoundException;
import com.pbl6.hotelbookingapp.dto.ChangePasswordRequest;
import com.pbl6.hotelbookingapp.dto.EditUserRequest;
import com.pbl6.hotelbookingapp.dto.UserDTO;
import com.pbl6.hotelbookingapp.entity.Role;
import com.pbl6.hotelbookingapp.entity.Token;
import com.pbl6.hotelbookingapp.entity.TokenType;
import com.pbl6.hotelbookingapp.entity.User;
import com.pbl6.hotelbookingapp.repository.TokenRepository;
import com.pbl6.hotelbookingapp.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;
    private final JwtService jwtService;

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();
        tokenRepository.save(token);
    }
    public User saveUserWithToken(User user)
    {
        if (repository.existsByEmail(user.getEmail())) { throw new RuntimeException("Email already exists"); }
        user.setRole(Role.NOT_REGISTERED_CUSTOMER);
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        saveUserToken(user,jwtToken);
        return user;
    }

    public void saveUser(User user)
    {
        repository.save(user);
    }
    public Optional<User> findByEmail(String email)
    {
        return repository.findByEmail(email);
    }
    public  boolean verifyToken(String token)
    {
        Optional<Token> confirmation = tokenRepository.findByToken(token);
        User user = repository.findByEmailIgnoreCase(confirmation.get().getUser().getEmail());
        if(user.getRole() == Role.CUSTOMER || user.getRole() == Role.HOST)
        {
            return Boolean.FALSE;
        }
        user.setRole(Role.CUSTOMER);
        repository.save(user);
        //confirmationRepository.delete(confirmation);
        return Boolean.TRUE;
    }

    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        // check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // save the new password
        repository.save(user);
    }
    public UserDTO getUserById(Integer id)
    {

        var user = repository.findById(id);
        if(!user.isPresent())
        {
            throw new ResponseException("User not found!");
        }
        return UserDTO.builder()
                .fullName(user.get().getFullName())
                .email(user.get().getEmail())
                .dateOfBirth(user.get().getDateOfBirth())
                .phoneNumber(user.get().getPhoneNumber())
                .gender(user.get().getGender())
                .build();
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
    @Transactional
    public void editNotRegisteredUser (Integer id, String name, String password, Role role){
        repository.updateUserDetails(id, name, password, role);
    }
    @Transactional
    public void editUser (EditUserRequest updateUser, Integer id){
        Optional<User> optionalUser = repository.findById(id);

        if (optionalUser.isPresent()) {
            if(!updateUser.getPhoneNumber().isBlank()){

                if (!Validator.validatePhoneNumber(updateUser.getPhoneNumber())){
                    throw new UserNotFoundException("Wrong phone number format!");
                }
            }
            repository.updateUserDetails(id,updateUser.getFullName(),
                                            updateUser.getPhoneNumber(),
                                            updateUser.getGender(),
                                            updateUser.getDateOfBirth());

        } else {
            throw new UserNotFoundException("User not found with id: " + id);
        }

    }

}
