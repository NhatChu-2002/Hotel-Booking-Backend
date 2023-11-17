package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.Exception.ResponseException;
import com.pbl6.hotelbookingapp.Exception.UserNotFoundException;
import com.pbl6.hotelbookingapp.dto.*;
import com.pbl6.hotelbookingapp.email.EmailService;
import com.pbl6.hotelbookingapp.entity.*;
import com.pbl6.hotelbookingapp.repository.*;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final RoomService roomService;
    private final RoomTypeService roomTypeService;
    private final HotelService hotelService;
    private final UserService userService;
    private final ReservationRepository reservationRepository;
    private final RoomReservedRepository roomReservedRepository;
    private final EmailService emailService;
    private final InvoiceRepository invoiceRepository;

    private final RoomRepository roomRepository;

    private final HotelImageRepository hotelImageRepository;

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
            reservation.setStatus(ReservationStatus.CONFIRMED);


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
    public ReservedHistoryResponse getHistory(Integer id)
    {
        ReservedHistoryResponse response = new ReservedHistoryResponse();
        List<Reservation> reservationList = reservationRepository.findAllByUserId(id);
        if(!reservationList.isEmpty())
        {
            List<ReservationDto> reservationDtoList = new ArrayList<>();
            for (Reservation reservation: reservationList) {
                ReservationDto reservationDto = new ReservationDto();
                List<RoomReserved> reservedList = roomReservedRepository.findAllByReservation(reservation);
                Hotel hotel = new Hotel();
                Map<RoomType, List<String>> roomTypeRoomNamesMap = new HashMap<>();
                boolean hotelSet = false;
                boolean daySet = false;
                int numberOfNights = 0;
                for (RoomReserved roomReserved : reservedList) {
                    if(!daySet)
                    {
                        reservationDto.setStartDay(roomReserved.getStartDay());
                        reservationDto.setEndDay(roomReserved.getEndDay());
                        numberOfNights = (int) ChronoUnit.DAYS.between(roomReserved.getStartDay(), roomReserved.getEndDay());
                        daySet = true;
                    }
                    if (!hotelSet) {
                        hotel = roomRepository.findHotelByRoomId(roomReserved.getRoom().getId());
                        if (hotel != null) {
                            hotelSet = true;
                        }
                    }
                    RoomType roomType = roomRepository.findRoomTypeByRoomId(roomReserved.getRoom().getId());
                    if (roomType != null) {
                        List<String> roomNames = roomTypeRoomNamesMap.getOrDefault(roomType, new ArrayList<>());
                        roomNames.add(roomReserved.getRoom().getName());
                        roomTypeRoomNamesMap.put(roomType, roomNames);

                    }
                }
                Set<RoomType> uniqueRoomTypes = roomTypeRoomNamesMap.keySet();


                List<RoomTypesResponse> roomTypesResponses = new ArrayList<>();

                for (RoomType roomType : uniqueRoomTypes) {
                    RoomTypesResponse roomTypesResponse = new RoomTypesResponse();
                    roomTypesResponse.setName(roomType.getName());

                    List<String> roomNames = roomTypeRoomNamesMap.get(roomType);
                    roomTypesResponse.setRoomName(roomNames);
                    roomTypesResponse.setCount(roomNames.size());
                    roomTypesResponse.setChildrenCount(roomType.getChildrenCount());
                    roomTypesResponse.setAdultCount(roomType.getAdultCount());
                    roomTypesResponse.setNightCount(numberOfNights);
                    roomTypesResponses.add(roomTypesResponse);
                }
                reservationDto.setRoomList(roomTypesResponses);
                reservationDto.setReservationCode(reservation.getReservationCode());
                reservationDto.setStatus(reservation.getStatus());
                reservationDto.setDescription(hotel.getDescription());
                reservationDto.setAddress(hotel.getStreet() +", " + hotel.getWard() + ", " + hotel.getDistrict() + ", " +hotel.getProvince());
                reservationDto.setProvince(hotel.getProvince());
                reservationDto.setImagePath(hotelImageRepository.findFirstImagePathByHotelId(hotel.getId()));
                reservationDto.setCheckInTime(hotel.getCheckInTime());
                reservationDto.setCheckOutTime(hotel.getCheckOutTime());
                reservationDto.setTotal(reservation.getTotalPrice());
                reservationDtoList.add(reservationDto);
            }
            response.setReservationList(reservationDtoList);
            response.setTotalItems(reservationDtoList.size());
        }
        else {
            response.setReservationList(null);
            response.setTotalItems(0);
        }


        return response;
    }
}