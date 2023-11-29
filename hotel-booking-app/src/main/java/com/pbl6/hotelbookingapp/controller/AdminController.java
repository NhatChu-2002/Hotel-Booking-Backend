package com.pbl6.hotelbookingapp.controller;

import com.pbl6.hotelbookingapp.Exception.ResponseException;
import com.pbl6.hotelbookingapp.Exception.UserNotFoundException;
import com.pbl6.hotelbookingapp.dto.EditUserRequest;
import com.pbl6.hotelbookingapp.dto.ErrorResponse;
import com.pbl6.hotelbookingapp.dto.UserListResponse;
import com.pbl6.hotelbookingapp.entity.HotelAmenity;
import com.pbl6.hotelbookingapp.entity.RoomAmenity;
import com.pbl6.hotelbookingapp.entity.User;
import com.pbl6.hotelbookingapp.service.HotelAmenityService;
import com.pbl6.hotelbookingapp.service.RoomAmenityService;
import com.pbl6.hotelbookingapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin("${allowed.origins}")
public class AdminController {
    private final HotelAmenityService hotelAmenityService;
    private final RoomAmenityService roomAmenityService;
    private  final UserService userService;

    @GetMapping("/hotelService/list")
    public ResponseEntity<?> getAllHotelAmenities() {
        try {
            List<HotelAmenity> list =  hotelAmenityService.getAllHotelAmenities();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/hotelService/{id}")
    public  ResponseEntity<?> getHotelAmenityById(@PathVariable Integer id) {
        try {
            HotelAmenity amenity =  hotelAmenityService.getHotelAmenityById(id);
            return ResponseEntity.ok().body(amenity);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/hotelService")
    public ResponseEntity<?> createHotelAmenity(@RequestBody HotelAmenity hotelAmenity) {
        try {
            HotelAmenity amenity = hotelAmenityService.createHotelAmenity(hotelAmenity);
            return ResponseEntity.ok().body(amenity);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/hotelService")
    public ResponseEntity<?>  updateHotelAmenity(@RequestBody HotelAmenity updatedAmenity) {
        try {
            Integer id = updatedAmenity.getId();
            HotelAmenity amenity =hotelAmenityService.updateHotelAmenity(id, updatedAmenity);
            return ResponseEntity.ok().body(amenity);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/hotelService/{id}")
    public ResponseEntity<?>  deleteHotelAmenity(@PathVariable Integer id) {
        try {
            hotelAmenityService.deleteHotelAmenity(id);

            return ResponseEntity.ok().body("Delete successfully!");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


    @GetMapping("/roomAmenity/list")
    public ResponseEntity<?> getAllRoomAmenities() {
        try {
            List<RoomAmenity> roomAmenities = roomAmenityService.getAllRoomAmenities();

            return ResponseEntity.ok().body(roomAmenities);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/roomAmenity/{id}")
    public ResponseEntity<?> getRoomAmenityById(@PathVariable Integer id) {
        try {
            RoomAmenity roomAmenity = roomAmenityService.getRoomAmenityById(id);

            return ResponseEntity.ok().body(roomAmenity);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/roomAmenity")
    public ResponseEntity<?> createRoomAmenity(@RequestBody RoomAmenity roomAmenity) {
        try {
            RoomAmenity newRoomAmenity = roomAmenityService.createRoomAmenity(roomAmenity);

            return ResponseEntity.ok().body(newRoomAmenity);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/roomAmenity")
    public ResponseEntity<?> updateRoomAmenity( @RequestBody RoomAmenity updatedAmenity) {
        try {
            Integer id = updatedAmenity.getId();
            RoomAmenity newRoomAmenity = roomAmenityService.updateRoomAmenity(id, updatedAmenity);

            return ResponseEntity.ok().body(newRoomAmenity);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/roomAmenity/{id}")
    public ResponseEntity<?> deleteRoomAmenity(@PathVariable Integer id) {
        try {
            roomAmenityService.deleteRoomAmenity(id);
            return ResponseEntity.ok().body("Delete successfully!");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/management/user/{id}")
    public ResponseEntity<?> editUser(@PathVariable Integer id, @RequestBody @Valid EditUserRequest updatedUser) {
        try{
            userService.editUser(updatedUser, id);
            return ResponseEntity.ok().body("Update user successfully");
        }
        catch(UserNotFoundException e)
        {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(e.getMessage()));
        }


    }
    @GetMapping("/management/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        try {
            var user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        }catch (ResponseException e)
        {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse(e.getMessage()));
        }

    }
    @GetMapping("/management/user/list")
    public ResponseEntity<UserListResponse> getAllUsers(
            @RequestParam(defaultValue = "1") int pageIndex,
            @RequestParam(defaultValue = "10") int pageSize) {

        UserListResponse usersResult = userService.getAllUsers(pageIndex, pageSize);
        return ResponseEntity.ok(usersResult);
    }
    @DeleteMapping("/management/user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.ok("User with ID " + userId + " has been deleted.");
        }catch (ResponseException e)
        {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse(e.getMessage()));
        }

    }
    @GetMapping("/management/user/search")
    public ResponseEntity<?> getUsersByEmail(@RequestParam("email") String email) {
        List<User> users = userService.findUserByEmailContaining(email);
        if (!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No users found", HttpStatus.NOT_FOUND);
        }
    }
}
