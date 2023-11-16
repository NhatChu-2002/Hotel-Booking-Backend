package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.Exception.ResponseException;
import com.pbl6.hotelbookingapp.Exception.UserNotFoundException;
import com.pbl6.hotelbookingapp.dto.*;
import com.pbl6.hotelbookingapp.email.EmailService;
import com.pbl6.hotelbookingapp.entity.*;
import com.pbl6.hotelbookingapp.repository.InvoiceRepository;
import com.pbl6.hotelbookingapp.repository.ReservationRepository;
import com.pbl6.hotelbookingapp.repository.RoomReservedRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
    private EmailService emailService;
    private InvoiceRepository invoiceRepository;

    public ReservationService(RoomService roomService, RoomTypeService roomTypeService, HotelService hotelService, UserService userService, ReservationRepository reservationRepository, RoomReservedRepository roomReservedRepository, EmailService emailService, InvoiceRepository invoiceRepository) {
        this.roomService = roomService;
        this.roomTypeService = roomTypeService;
        this.hotelService = hotelService;
        this.userService = userService;
        this.reservationRepository = reservationRepository;
        this.roomReservedRepository = roomReservedRepository;
        this.emailService = emailService;
        this.invoiceRepository = invoiceRepository;
    }

    public boolean checkReservation(ReservationRequest request)
    {
        Optional<Hotel> hotel = hotelService.findHotelById(request.getHotelId());
        if (!hotel.isPresent()){
            throw new ResponseException("Hotel not found!");
        }
        List<RoomTypeReserved> roomTypeCheck = request.getRoomTypeReservedList();
        for (RoomTypeReserved roomTypeReserve : roomTypeCheck) {
            Optional<RoomType> roomTypeOptional = roomTypeService.findRoomTypeByIdAndHotelId(roomTypeReserve.getId(), request.getHotelId());

            if (roomTypeOptional.isEmpty()) {
                return false;
            }
        }
        for (RoomTypeReserved roomTypeReserve : roomTypeCheck) {
            Optional<RoomType> roomTypeOptional = roomTypeService.findRoomTypeByIdAndHotelId(roomTypeReserve.getId(), request.getHotelId());
            RoomTypesResponse roomTypesResponse = new RoomTypesResponse();

            List<Room> roomForType = roomService.getAvailableRooms(roomTypeOptional.get(),
                    request.getStartDay(),
                    request.getEndDay(),
                    roomTypeReserve.getCount());

            if (roomForType.size() < roomTypeReserve.getCount()) {

                return false;
            }
        }
        return true;
    }
    public ReservationResponse makeReservation(ReservationRequest request) {

        Optional<Hotel> hotel = hotelService.findHotelById(request.getHotelId());
        if (!hotel.isPresent()){
            throw new ResponseException("Hotel not found!");
        }
        List<RoomTypeReserved> roomTypeCheck = request.getRoomTypeReservedList();
        boolean allRoomTypesExist = true;
        for (RoomTypeReserved roomTypeReserve : roomTypeCheck) {
            Optional<RoomType> roomTypeOptional = roomTypeService.findRoomTypeByIdAndHotelId(roomTypeReserve.getId(), request.getHotelId());

            if (roomTypeOptional.isEmpty()) {
                allRoomTypesExist = false;
                break;
            }
        }
        if (!allRoomTypesExist) {
            throw new ResponseException("Room type not found!");
        }

        Optional<User> user = userService.findByEmail(request.getEmail());
        User saveUser;
        if (!user.isPresent()){
            var newUser = User.builder()
                    .fullName(request.getName())
                    .email(request.getEmail())
                    .phoneNumber(request.getPhoneNumber())
                    .password(null)
                    .role(Role.NOT_REGISTERED_CUSTOMER)
                    .build();
            userService.saveUser(newUser);
            saveUser = newUser;
        }
        else {
            saveUser = user.get();
        }

        try {
            List<Room> availableRooms = new ArrayList<>();
            List<RoomTypesResponse> roomTypesResponses = new ArrayList<>();
            LocalDate startDay =request.getStartDay();
            LocalDate endDay = request.getEndDay();

            long numberOfNights = ChronoUnit.DAYS.between(startDay, endDay);
            for (RoomTypeReserved roomTypeReserve : roomTypeCheck) {
                Optional<RoomType> roomTypeOptional = roomTypeService.findRoomTypeByIdAndHotelId(roomTypeReserve.getId(), request.getHotelId());
                RoomTypesResponse roomTypesResponse = new RoomTypesResponse();

                List<Room> roomForType = roomService.getAvailableRooms(roomTypeOptional.get(),
                        request.getStartDay(),
                        request.getEndDay(),
                        roomTypeReserve.getCount());

                if (roomForType.size() < roomTypeReserve.getCount()) {
                    throw new ResponseException("Not enough room!");
                }
                List<String> roomName = new ArrayList<>();
                for (Room room: roomForType) {
                    roomName.add(room.getName());
                }

                roomTypesResponse.setRoomName(roomName);
                roomTypesResponse.setName(roomTypeOptional.get().getName());
                roomTypesResponse.setAdultCount(roomTypeOptional.get().getAdultCount());
                roomTypesResponse.setChildrenCount(roomTypeOptional.get().getChildrenCount());
                roomTypesResponse.setCount(roomTypeReserve.getCount());
                roomTypesResponse.setNightCount((int)numberOfNights);
                roomTypesResponses.add(roomTypesResponse);


                availableRooms.addAll(roomForType);
            }
            Reservation reservation = new Reservation();
            reservation.setUser(saveUser);
            reservation.setEmail(saveUser.getEmail());
            reservation.setStatus(ReservationStatus.CONFIRMED);

            reservation.setSiteFee(request.getTotalPrice()*20/100);
            reservation.setTaxPaid(request.getTax());
            reservation.setTotalPrice(request.getVat());
            String reservationCode = ReservationCodeGenerator.generateReservationCode();
            reservation.setReservationCode(reservationCode);


            ReservationResponse reservationResponse = ReservationResponse.builder()
                    .hotelName(hotel.get().getName())
                    .province(hotel.get().getProvince())
                    .address(hotel.get().getStreet())
                    .checkInTime(hotel.get().getCheckInTime())
                    .checkOutTime(hotel.get().getCheckOutTime())
                    .roomList(roomTypesResponses)
                    .description(hotel.get().getDescription())
                    .total(request.getVat())
                    .endDay(request.getEndDay())
                    .startDay(request.getStartDay())
                    .reservationCode(reservationCode)
                    .build();
            emailService.sendReservationConfirmationEmail(reservationResponse,saveUser.getEmail());
            reservationRepository.save(reservation);

            for (int i = 0; i < availableRooms.size(); i++) {

                    RoomReserved roomReserved = new RoomReserved();
                    roomReserved.setReservation(reservation);
                    roomReserved.setRoom(availableRooms.get(i));
                    roomReserved.setStartDay(request.getStartDay());
                    roomReserved.setEndDay(request.getEndDay());
                    roomReservedRepository.save(roomReserved);
            }



            return reservationResponse;
        } catch (ResponseException e) {
            throw new ResponseException(e.getMessage());
        }
    }
}