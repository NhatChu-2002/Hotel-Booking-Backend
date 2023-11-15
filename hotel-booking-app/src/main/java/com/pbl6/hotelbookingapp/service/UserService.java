package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.Exception.UserNotFoundException;
import com.pbl6.hotelbookingapp.dto.ChangePasswordRequest;
import com.pbl6.hotelbookingapp.dto.EditUserRequest;
import com.pbl6.hotelbookingapp.entity.Role;
import com.pbl6.hotelbookingapp.entity.User;
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
public class UserService {

    private PasswordEncoder passwordEncoder;
    private UserRepository repository;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder)
    {
        this.passwordEncoder = passwordEncoder;
        this.repository = userRepository;
    }
    public Optional<User> findByEmail(String email)
    {
        return repository.findByEmail(email);
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
    public void saveUser(User user)
    {
        repository.save(user);
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
            if (repository.existsByEmailAndIdNot(updateUser.getEmail(), id))
            {
                throw new UserNotFoundException("Email already exists!");
            }
            if(!updateUser.getPhoneNumber().isBlank()){

                if (!Validator.validatePhoneNumber(updateUser.getPhoneNumber())){
                    throw new UserNotFoundException("Wrong phone number format!");
                }
            }
            repository.updateUserDetails(id,updateUser.getFullName(),
                                            updateUser.getEmail(),
                                            updateUser.getPhoneNumber(),
                                            updateUser.getGender(),
                                            updateUser.getDateOfBirth());

        } else {
            throw new UserNotFoundException("User not found with id: " + id);
        }

    }

}
