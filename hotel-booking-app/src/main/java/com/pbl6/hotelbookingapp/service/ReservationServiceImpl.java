package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.Exception.ResponseException;
import com.pbl6.hotelbookingapp.dto.*;
import com.pbl6.hotelbookingapp.email.EmailService;
import com.pbl6.hotelbookingapp.entity.*;
import com.pbl6.hotelbookingapp.repository.*;

import io.jsonwebtoken.io.IOException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final RoomService roomService;
    private final RoomTypeService roomTypeService;
    private final HotelService hotelService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;
    private final RoomReservedRepository roomReservedRepository;
    private final EmailService emailService;
    private final InvoiceRepository invoiceRepository;

    private final RoomRepository roomRepository;

    private final HotelImageRepository hotelImageRepository;
    private final PaymentService paymentService;

    @Override
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
    @Override
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
        if (!user.isPresent() || user.get().isDeleted()){
            var newUser = User.builder()
                    .fullName(request.getName())
                    .email(request.getEmail())
                    .phoneNumber(request.getPhoneNumber())
                    .password(null)
                    .role(Role.NOT_REGISTERED_CUSTOMER)
                    .isDeleted(false)
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
            reservation.setHotel(hotel.get());


            ReservationResponse reservationResponse = ReservationResponse.builder()
                    .userId(saveUser.getId())
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
                    .status(ReservationStatus.CONFIRMED)
                    .build();
//            emailService.sendReservationConfirmationEmail(reservationResponse,saveUser.getEmail());
            reservationRepository.save(reservation);

            for (int i = 0; i < availableRooms.size(); i++) {

                    RoomReserved roomReserved = new RoomReserved();
                    roomReserved.setReservation(reservation);
                    roomReserved.setRoom(availableRooms.get(i));
                    roomReserved.setStartDay(request.getStartDay());
                    roomReserved.setEndDay(request.getEndDay());
                    roomReservedRepository.save(roomReserved);
            }
            Invoice newInvoice = new Invoice();
            if(request.getPaymentMethod().toLowerCase().equals("cash") )
            {
                newInvoice.setUser(saveUser);
                newInvoice.setInvoiceAmount(reservation.getTotalPrice());
                newInvoice.setTimePaid(null);
                newInvoice.setVnpRef(null);
                newInvoice.setVnpTransdate(null);
                newInvoice.setPaymentType(PaymentType.CASH);
                newInvoice.setReservation(reservation);
                invoiceRepository.save(newInvoice);
            }
            else {
                newInvoice.setUser(saveUser);
                newInvoice.setInvoiceAmount(reservation.getTotalPrice());
                LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
                newInvoice.setTimePaid(localDateTime);
                newInvoice.setVnpRef(request.getOrderId());
                newInvoice.setVnpTransdate(request.getTransDate());
                newInvoice.setPaymentType(PaymentType.CREDIT_CARD);
                newInvoice.setReservation(reservation);
                invoiceRepository.save(newInvoice);
            }



            return reservationResponse;
        } catch (ResponseException e) {
            throw new ResponseException(e.getMessage());
        }
    }
    @Override
    public ReservationDto getReservationByCode(String reservationCode)
    {
        try {
            ReservationDto reservationDto = new ReservationDto();
            Reservation reservation = reservationRepository.findFirstByReservationCode(reservationCode).get();
            if(reservation.getStatus() == ReservationStatus.CANCELLED)
            {
                reservationDto.setReservationCode(reservation.getReservationCode());

            }
            else {
                getReservationDetails(reservationDto, reservation);
            }

            return reservationDto;
        }
        catch (ResponseException e)
        {
            throw new ResponseException(e.getMessage());
        }

    }
    private void getReservationDetails(ReservationDto reservationDto, Reservation reservation) {
        List<RoomReserved> reservedList = roomReservedRepository.findAllByReservation(reservation);
        Hotel hotel = new Hotel();
        Map<RoomType, List<String>> roomTypeRoomNamesMap = new HashMap<>();
        boolean hotelSet = false;
        boolean daySet = false;
        int numberOfNights = 0;
        for (RoomReserved roomReserved : reservedList) {
            if (!daySet) {
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
        reservationDto.setHotelName(hotel.getName());
        reservationDto.setRoomList(roomTypesResponses);
        reservationDto.setReservationCode(reservation.getReservationCode());
        reservationDto.setStatus(reservation.getStatus());
        reservationDto.setDescription(hotel.getDescription());
        reservationDto.setAddress(hotel.getStreet() + ", " + hotel.getWard() + ", " + hotel.getDistrict() + ", " + hotel.getProvince());
        reservationDto.setProvince(hotel.getProvince());
        reservationDto.setImagePath(hotelImageRepository.findFirstImagePathByHotelId(hotel.getId()));
        reservationDto.setCheckInTime(hotel.getCheckInTime());
        reservationDto.setCheckOutTime(hotel.getCheckOutTime());
        reservationDto.setTotal(reservation.getTotalPrice());
    }

    @Override
    public ReservedHistoryResponse getHistory(Integer id)
    {
        if(userRepository.findById(id).get().isDeleted())
        {
            throw new ResponseException("user not found!");
        }
        ReservedHistoryResponse response = new ReservedHistoryResponse();
        List<Reservation> reservationList = reservationRepository.findAllByUserId(id);
        if(!reservationList.isEmpty())
        {
            List<ReservationDto> reservationDtoList = new ArrayList<>();
            List<CancelledReservationDTO> cancelledReservationList = new ArrayList<>();

            for (Reservation reservation: reservationList) {


                if(reservation.getStatus() == ReservationStatus.CANCELLED)
                {
                    Invoice invoice = invoiceRepository.findByReservation(reservation).get();
                    Hotel hotel = hotelService.getHotelById(reservation.getHotel().getId());
                    CancelledReservationDTO cancelledReservationDTO = new CancelledReservationDTO();
                    cancelledReservationDTO.setReservationCode(reservation.getReservationCode());
                    cancelledReservationDTO.setHotelName(hotel.getName());
                    cancelledReservationDTO.setTimeCancelled(invoice.getTimeCanceled());
                    cancelledReservationDTO.setTimePaid(invoice.getTimePaid());
                    cancelledReservationDTO.setPaidAmount(invoice.getInvoiceAmount());
                    cancelledReservationDTO.setRefundAmount(invoice.getRefundAmount());
                    cancelledReservationDTO.setAddress(hotel.getStreet() +", " + hotel.getWard() + ", " + hotel.getDistrict() + ", " +hotel.getProvince());
                    cancelledReservationDTO.setStatus(reservation.getStatus());
                    cancelledReservationDTO.setImagePath(hotelImageRepository.findFirstImagePathByHotelId(hotel.getId()));
                    cancelledReservationList.add(cancelledReservationDTO);

                }
                else{
                    ReservationDto reservationDto = new ReservationDto();
                    getReservationDetails(reservationDto, reservation);
                    reservationDtoList.add(reservationDto);
                }



            }
            response.setReservationList(reservationDtoList);
            response.setCancelList(cancelledReservationList);
            response.setTotalReservation(reservationDtoList.size());
            response.setTotalCancel(cancelledReservationList.size());
        }
        else {
            response.setReservationList(null);
            response.setCancelList(null);
            response.setTotalCancel(0);
            response.setTotalReservation(0);
        }

        return response;
    }
    @Override
    public Invoice saveInvoice(SaveInvoiceRequest request)
    {
        try{
            Invoice newInvoice = new Invoice();

            User user = userRepository.findById(request.getUserId()).get();
            Reservation reservation = reservationRepository.findFirstByReservationCode(request.getReservationCode()).get();
            newInvoice.setUser(user);
            newInvoice.setInvoiceAmount(request.getPrice());

            LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
            newInvoice.setTimePaid(localDateTime);
            newInvoice.setVnpRef(request.getOrderId());
            newInvoice.setVnpTransdate(request.getTransDate());
            newInvoice.setPaymentType(PaymentType.CREDIT_CARD);
            newInvoice.setReservation(reservation);


            return invoiceRepository.save(newInvoice);
        }catch (ResponseException e)
        {
            throw new ResponseException(e.getMessage());
        }

    }
    @Override
    @Transactional
    public CancelResponse cancelReservation(CancelRequest request) throws IOException
    {
        try {
            Optional<Reservation> reservation = reservationRepository.findFirstByReservationCode(request.getReservationCode());
            if(!reservation.isPresent())
            {
                throw new ResponseException("no reservation found!");
            }
            Reservation foundReservation = reservation.get();
            Optional<Invoice> findInvoice = invoiceRepository.findByReservation(reservation.get());
            if(foundReservation.getStatus().equals(ReservationStatus.CANCELLED))
            {
                throw new ResponseException("already cancelled!");
            }
            if(!findInvoice.isPresent())
            {
                throw new ResponseException("no invoice found!");
            }
            List<RoomReserved> reservedList =  roomReservedRepository.findAllByReservation(reservation.get());
            if(reservedList.isEmpty())
            {
                throw new ResponseException("no room found!");
            }
            foundReservation.setStatus(ReservationStatus.CANCELLED);
            RoomReserved firstRoomReserved = reservedList.get(0);
            String hotelName = roomRepository.findHotelByRoomId(firstRoomReserved.getRoom().getId()).getName();
            LocalDate checkInDate = firstRoomReserved.getStartDay();
            LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
            LocalDate cancellationDate = localDateTime.toLocalDate();

            long daysUntilCheckIn = ChronoUnit.DAYS.between(cancellationDate, checkInDate);

            double refundPercentage = 0.0;
            String tranType = new String();
            if (daysUntilCheckIn >= 2) {
                refundPercentage = 1.0;
                tranType = "02";
            } else if (daysUntilCheckIn > 0) {
                refundPercentage = 0.9;
                tranType = "03";
            }
            if (refundPercentage == 0.0)
            {
                throw new ResponseException("Cannot cancelled!");
            }
            Invoice invoice = findInvoice.get();

            RefundResponse refundResponse = paymentService.refund(tranType,
                                                                invoice.getVnpRef(),
                                                                invoice.getInvoiceAmount()*refundPercentage,
                                                                invoice.getVnpTransdate(),
                                                                foundReservation.getEmail());

            if(refundResponse.getVnp_Message().equals("Refund success"))
            {
                invoice.setTimeCanceled(localDateTime);
                invoice.setRefundAmount((long) (invoice.getInvoiceAmount()*refundPercentage));

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String formattedCancellationDate = cancellationDate.format(formatter);

                CancelResponse cancelResponse = CancelResponse.builder()
                        .hotelName(hotelName)
                        .reservationCode(foundReservation.getReservationCode())
                        .orderId(invoice.getVnpRef())
                        .cancelDate(formattedCancellationDate)
                        .amount(invoice.getInvoiceAmount().toString())
                        .refundAmount(invoice.getInvoiceAmount()*refundPercentage)
                        .build();
//                emailService.sendCancellationEmail(cancelResponse, foundReservation.getEmail());

                invoiceRepository.save(invoice);
                roomReservedRepository.deleteAllByReservation(foundReservation);
                reservationRepository.save(foundReservation);
                return cancelResponse;
            }
            else {
                throw new ResponseException(refundResponse.getVnp_Message());
            }
        }
        catch (ResponseException e)
        {
            throw new ResponseException(e.getMessage());
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }

    }
}