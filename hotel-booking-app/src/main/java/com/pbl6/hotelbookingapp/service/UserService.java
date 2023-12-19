package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.dto.*;
import com.pbl6.hotelbookingapp.entity.Role;
import com.pbl6.hotelbookingapp.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

public interface UserService {


    void saveUserToken(User user, String jwtToken);

    User saveUserWithToken(User user);

    void saveUser(User user);

    Optional<User> findByEmail(String email);

    boolean verifyToken(String token);

    void changePassword(ChangePasswordRequest request, Principal connectedUser);

    UserDTO getUserById(Integer id);

    List<String> getReservationCodes(User tempUser);

    UserListResponse getAllUsers(int pageIndex, int pageSize);

    @Transactional
    void editNotRegisteredUser(Integer id, String name, String password, Role role);

    @Transactional
    void editUser(EditUserRequest updateUser, Integer id);

    @Transactional
    void deleteUser(Integer userId);

    Page<User> findUsersByEmailContaining(String email, Pageable pageable);
}
