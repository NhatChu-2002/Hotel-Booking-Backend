package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.Exception.ResponseException;
import com.pbl6.hotelbookingapp.Exception.UserNotFoundException;
import com.pbl6.hotelbookingapp.dto.*;
import com.pbl6.hotelbookingapp.entity.*;
import com.pbl6.hotelbookingapp.repository.HotelRepository;
import com.pbl6.hotelbookingapp.repository.ReservationRepository;
import com.pbl6.hotelbookingapp.repository.TokenRepository;
import com.pbl6.hotelbookingapp.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;
    private final JwtService jwtService;
    private final HotelRepository hotelRepository;
    private final ReservationRepository reservationRepository;

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


        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }

        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        repository.save(user);
    }
    public UserDTO getUserById(Integer id) {

        var user = repository.findById(id);
        if (!user.isPresent() || user.get().isDeleted()) {
            throw new ResponseException("User not found!");
        } else {
            User tempUser = user.get();
            if (tempUser.getRole().equals(Role.CUSTOMER) || tempUser.getRole().equals(Role.NOT_REGISTERED_CUSTOMER)) {
                List<String> reservationCodes = getReservationCodes(tempUser);

                return buildUserDTO( tempUser, reservationCodes, null);

            } else if (tempUser.getRole().equals(Role.HOST)) {
                List<String> reservationCodes = getReservationCodes(tempUser);
                List<Hotel> hotels = hotelRepository.findAllByUserId(tempUser.getId());
                List<HotelAdminResponse> hotelAdminResponses = new ArrayList<>();
                if(!hotels.isEmpty())
                {
                    for (Hotel hotel : hotels) {
                        var hotelAdminResponse = HotelAdminResponse
                                .builder()
                                .hotelName(hotel.getName())
                                .status(hotel.getStatus())
                                .build();
                        hotelAdminResponses.add(hotelAdminResponse);
                    }
                }

                return buildUserDTO( tempUser, reservationCodes, hotelAdminResponses);
            } else {
                return buildUserDTO( tempUser, null, null);
            }
        }

    }


    private static UserDTO buildUserDTO(User tempUser, List<String> reservationCodes, List<HotelAdminResponse> hotelAdminResponses) {
        int hotelCount = (hotelAdminResponses != null) ? hotelAdminResponses.size() : 0;
        int reservationCount = (reservationCodes != null) ? reservationCodes.size() : 0;
        return UserDTO.builder()
                .hotelList(hotelAdminResponses)
                .reservationList(reservationCodes)
                .hotelCount(hotelCount)
                .reservationCount(reservationCount)
                .fullName(tempUser.getFullName())
                .email(tempUser.getEmail())
                .dateOfBirth(tempUser.getDateOfBirth())
                .phoneNumber(tempUser.getPhoneNumber())
                .gender(tempUser.getGender())
                .dateCreated(tempUser.getCreatedAt())
                .build();
    }

    private List<String> getReservationCodes(User tempUser) {
        List<Reservation> reservationList = reservationRepository.findAllByUserId(tempUser.getId());
        List<String> reservationCodes = new ArrayList<>();
        if (!reservationList.isEmpty()) {
            for (Reservation reservation : reservationList) {
                reservationCodes.add(reservation.getReservationCode());
            }
        }
        return reservationCodes;
    }

    public UserListResponse getAllUsers(int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex-1, pageSize);
        Page<User> usersPage = repository.findByIsDeletedFalse(pageable);

        List<User> users = usersPage.getContent();
        long totalUsers = usersPage.getTotalElements();
        long totalPages = usersPage.getTotalPages();

        return new UserListResponse(users, totalUsers,totalPages);
    }
    @Transactional
    public void editNotRegisteredUser (Integer id, String name, String password, Role role){
        repository.updateUserDetails(id, name, password, role);
    }
    @Transactional
    public void editUser (EditUserRequest updateUser, Integer id){
        Optional<User> optionalUser = repository.findById(id);

        if (optionalUser.isPresent() && !optionalUser.get().isDeleted()) {
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
    @Transactional
    public void deleteUser(Integer userId) {
        User user = repository.findById(userId).orElse(null);
        if (user != null) {
            user.setEmail(null);
            user.setDeleted(true);
            repository.save(user);
        }
    }
    public List<User> findUserByEmailContaining(String email) {
        return repository.findByEmailIgnoreCaseContaining(email);
    }

}
