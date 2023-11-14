package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.Exception.ResponseException;
import com.pbl6.hotelbookingapp.Exception.UserNotFoundException;
import com.pbl6.hotelbookingapp.dto.ReservationRequest;
import com.pbl6.hotelbookingapp.dto.ReservationResponse;
import com.pbl6.hotelbookingapp.entity.*;
import com.pbl6.hotelbookingapp.repository.ReservationRepository;
import com.pbl6.hotelbookingapp.repository.RoomReservedRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private RoomService roomService;
    private RoomTypeService roomTypeService;
    private HotelService hotelService;
    private UserService userService;
    private ReservationRepository reservationRepository;
    private RoomReservedRepository roomReservedRepository;


    public ReservationService(RoomService roomService, RoomTypeService roomTypeService, HotelService hotelService, UserService userService, ReservationRepository reservationRepository, RoomReservedRepository roomReservedRepository) {
        this.roomService = roomService;
        this.roomTypeService = roomTypeService;
        this.hotelService = hotelService;
        this.userService = userService;
        this.reservationRepository = reservationRepository;
        this.roomReservedRepository = roomReservedRepository;
    }


    public ReservationResponse makeReservation(ReservationRequest request) {

        Optional<Hotel> hotel = hotelService.findHotelById(request.getHotelId());
        if (!hotel.isPresent()){
            throw new ResponseException("Hotel not found!");
        }
        Optional<RoomType> roomType = roomTypeService.findRoomTypeByNameAndHotelId(request.getRoomType(), request.getHotelId());
        if (!roomType.isPresent()){
            throw new ResponseException("Room type not found!");
        }
        Optional<User> user = userService.findByEmail(request.getEmail());
        User saveUser;
        if (!user.isPresent()){
            var newUser = User.builder()
                    .fullName(null)
                    .email(request.getEmail())
                    .password(null)
                    .role(Role.NOT_REGISTERED_CUSTOMER)
                    .build();
            userService.saveUser(newUser);
            saveUser = newUser;
        }
        else {
            saveUser = user.get();
        }
        List<Room> availableRooms = roomService.getAvailableRooms(roomType.get(),
                                                                    request.getStartDay(),
                                                                    request.getEndDay(),
                                                                    request.getCount());

        if (availableRooms.size() < request.getCount()) {
            throw new ResponseException("Room not found!");
        }

        try {

            Reservation reservation = new Reservation();

            reservation.setUser(saveUser);
            reservation.setEmail(saveUser.getEmail());
            reservation.setStatus(ReservationStatus.CONFIRMED);

            Double price = roomType.get().getPrice();
            Double siteFee = price* request.getCount() *20/100;
            Double tax =  price* request.getCount() *10/100;
            Double total =  price* request.getCount() + tax;

            reservation.setSiteFee(siteFee);
            reservation.setTaxPaid(tax);
            reservation.setTotalPrice(total);

            reservationRepository.save(reservation);


            // Đánh dấu các phòng đã được đặt
            for (int i = 0; i < request.getCount(); i++) {
                RoomReserved roomReserved = new RoomReserved();
                roomReserved.setReservation(reservation);
                roomReserved.setRoom(availableRooms.get(i));
                roomReserved.setStartDay(request.getStartDay());
                roomReserved.setEndDay(request.getEndDay());
                roomReservedRepository.save(roomReserved);
            }
            return ReservationResponse.builder()
                    .hotelName(hotel.get().getName())
                    .province(hotel.get().getProvince())
                    .address(hotel.get().getStreet())
                    .roomType(request.getRoomType())
                    .count(request.getCount())
                    .total(total)
                    .endDay(request.getEndDay())
                    .startDay(request.getStartDay()).build();
        } catch (ResponseException e) {
            throw new ResponseException(e.getMessage());
        }
    }
}