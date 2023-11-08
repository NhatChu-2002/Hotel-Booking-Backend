package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.dto.ReservationRequest;
import com.pbl6.hotelbookingapp.entity.*;
import com.pbl6.hotelbookingapp.repository.ReservationRepository;
import com.pbl6.hotelbookingapp.repository.RoomReservedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private RoomService roomService;
    private RoomTypeService roomTypeService;
    private HotelService hotelService;
    private ReservationRepository reservationRepository;
    private RoomReservedRepository roomReservedRepository;


    public ReservationService(RoomService roomService, RoomTypeService roomTypeService, HotelService hotelService, ReservationRepository reservationRepository, RoomReservedRepository roomReservedRepository) {

        this.roomService = roomService;
        this.roomTypeService = roomTypeService;
        this.hotelService = hotelService;
        this.reservationRepository = reservationRepository;
        this.roomReservedRepository = roomReservedRepository;
    }
    public void makeReservation(ReservationRequest request) {
        List<Room> availableRooms = roomService.getAvailableRooms(request.getHotelName(),
                                                                    request.getProvince(),
                                                                    request.getAddress(),
                                                                    request.getRoomType(),
                                                                    request.getStartDay(),
                                                                    request.getEndDay(),
                                                                    request.getCount());


        if (availableRooms.size() < request.getCount()) {
            throw new RuntimeException("Số lượng phòng không đủ.");
        }

        // Tiến hành đặt phòng
        try {
//            Reservation reservation = new Reservation();
//            reservation.setUser();
//            reservation.setEmail();
//            reservation.setStatus();
//            reservation.setSiteFee();
//            reservation.setTaxPaid();
//            reservation.setTotalPrice();
//
//            RoomReserved roomReserved = new RoomReserved();
//            roomReserved.setReservation(reservation);
//            roomReserved.setRoom();
//            roomReserved.setStartDay();
//            roomReserved.setEndDay();



//            reservationRepository.save(reservation);
//            roomReservedRepository.save(roomReserved);

            // Đánh dấu các phòng đã được đặt
            for (int i = 0; i < request.getCount(); i++) {
//                Room room = availableRooms.get(i);
//                roomService.markRoomAsReserved(room.getId(), reservation.getId());
            }
        } catch (Exception e) {
            throw new RuntimeException("Đặt phòng không thành công.");
        }
    }
}