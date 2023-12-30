package com.pbl6.hotelbookingapp.controller;

import com.pbl6.hotelbookingapp.Exception.ResponseException;
import com.pbl6.hotelbookingapp.Exception.UserNotFoundException;
import com.pbl6.hotelbookingapp.dto.*;
import com.pbl6.hotelbookingapp.entity.*;
import com.pbl6.hotelbookingapp.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private final BedTypeService bedTypeService;
    private final ViewService viewService;
    private final HotelService hotelService;

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
    @GetMapping("/roomAmenity/search")
    public ResponseEntity<?> searchAmenities(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int pageIndex,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        try {
            Pageable pageable = PageRequest.of(pageIndex, pageSize);
            AmenitySearchResponse amenities = roomAmenityService.searchAmenities(name, pageable);
            return ResponseEntity.ok().body(amenities);
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
    public ResponseEntity<?> getUsersByEmail(
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") int pageIndex,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        try {
            Pageable pageable = PageRequest.of(pageIndex, pageSize);
            Page<User> users = userService.findUsersByEmailContaining(email, pageable);

            if (users.hasContent()) {
                return ResponseEntity.ok().body(users);
            } else {
                return new ResponseEntity<>("No users found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @GetMapping("/bedTypes/list")
    public ResponseEntity<?> getAllBedTypes() {
        try {
            List<BedType> bedTypes = bedTypeService.getAllBedTypes();
            return new ResponseEntity<>(bedTypes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/bedTypes/{id}")
    public ResponseEntity<BedType> getBedTypeById(@PathVariable Integer id) {
        return bedTypeService.getBedTypeById(id)
                .map(bedType -> new ResponseEntity<>(bedType, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/bedTypes")
    public ResponseEntity<BedType> createBedType(@RequestBody BedType bedType) {
        BedType createdBedType = bedTypeService.createOrUpdateBedType(bedType);
        return new ResponseEntity<>(createdBedType, HttpStatus.CREATED);
    }

    @PutMapping("/bedTypes/{id}")
    public ResponseEntity<BedType> updateBedType(@PathVariable Integer id, @RequestBody BedType bedType) {
        bedType.setId(id);
        BedType updatedBedType = bedTypeService.createOrUpdateBedType(bedType);
        return new ResponseEntity<>(updatedBedType, HttpStatus.OK);
    }

    @DeleteMapping("/bedTypes/{id}")
    public ResponseEntity<?> deleteBedType(@PathVariable Integer id) {
        try {
            bedTypeService.deleteBedTypeById(id);
            return ResponseEntity.ok("Bed type with ID " + id + " has been deleted.");
        }catch (ResponseException e)
        {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse(e.getMessage()));
        }

    }
    @GetMapping("/bedTypes/search")
    public ResponseEntity<Page<BedType>> searchBedTypeByNameContaining(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int pageIndex,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        try {
            Pageable pageable = PageRequest.of(pageIndex, pageSize);
            Page<BedType> bedTypes = bedTypeService.findBedTypesByNameContaining(name, pageable);

            if (bedTypes.hasContent()) {
                return ResponseEntity.ok().body(bedTypes);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @GetMapping("/views/list")
    public ResponseEntity<List<View>> getAllViews() {
        List<View> views = viewService.getAllViews();
        return new ResponseEntity<>(views, HttpStatus.OK);
    }

    @GetMapping("/views/{id}")
    public ResponseEntity<View> getViewById(@PathVariable Integer id) {
        return viewService.getViewById(id)
                .map(view -> new ResponseEntity<>(view, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/views")
    public ResponseEntity<View> createView(@RequestBody View view) {
        View createdView = viewService.createOrUpdateView(view);
        return new ResponseEntity<>(createdView, HttpStatus.CREATED);
    }

    @PutMapping("/views/{id}")
    public ResponseEntity<View> updateView(@PathVariable Integer id, @RequestBody View view) {
        view.setId(id);
        View updatedView = viewService.createOrUpdateView(view);
        return new ResponseEntity<>(updatedView, HttpStatus.OK);
    }

    @DeleteMapping("/views/{id}")
    public ResponseEntity<?> deleteView(@PathVariable Integer id) {
        try {
            viewService.deleteViewById(id);
            return ResponseEntity.ok("View with ID " + id + " has been deleted.");
        }catch (ResponseException e)
        {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse(e.getMessage()));
        }

    }

    @GetMapping("/views/search")
    public ResponseEntity<Page<View>> searchViewByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int pageIndex,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        try {
            Pageable pageable = PageRequest.of(pageIndex, pageSize);
            Page<View> views = viewService.findViewsByNameContaining(name, pageable);

            if (views.hasContent()) {
                return ResponseEntity.ok().body(views);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping ("/revenue/by-year")
    public ResponseEntity<List<RevenueResponse>> getRevenueForAdminByYear(@RequestBody RevenueRequest revenueRequest) {
        List<RevenueResponse> revenueList = hotelService.getRevenueForAdminByYear(revenueRequest.getYear());
        return new ResponseEntity<>(revenueList, HttpStatus.OK);
    }

    @GetMapping  ("/revenue")
    public ResponseEntity<List<RevenueByYearResponse>> getRevenueForAdminByYear() {
        List<RevenueByYearResponse> revenueList = hotelService.getRevenueForAdmin();
        return new ResponseEntity<>(revenueList, HttpStatus.OK);
    }
    @GetMapping("/hotels/pending")
    public ResponseEntity<List<PendingHotelResponse>> getPendingHotels() {
        List<PendingHotelResponse> pendingHotels = hotelService.getPendingHotels();
        if (pendingHotels.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pendingHotels);
    }
    @PutMapping("/hotels/{hotelId}/approve")
    public ResponseEntity<String> approveHotel(@PathVariable Integer hotelId) {
        hotelService.approveHotel(hotelId);
        return ResponseEntity.ok("Hotel approved successfully");
    }
    @PutMapping("/hotels/{hotelId}/decline")
    public ResponseEntity<String> declineHotel(@PathVariable Integer hotelId) {
        hotelService.declineHotel(hotelId);
        return ResponseEntity.ok("Hotel declined successfully");
    }
}
