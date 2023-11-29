package com.pbl6.hotelbookingapp.controller;

import com.pbl6.hotelbookingapp.Exception.ResponseException;
import com.pbl6.hotelbookingapp.Exception.UserNotFoundException;
import com.pbl6.hotelbookingapp.dto.*;
import com.pbl6.hotelbookingapp.service.HotelService;
import com.pbl6.hotelbookingapp.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("api/reservation")
@CrossOrigin("${allowed.origins}")
public class ReservationController {
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/history")
    public ResponseEntity<?> getHistory(@RequestBody  GenericRequest<Integer> request) {
        try{
            ReservedHistoryResponse response= reservationService.getHistory(request.getRequestData());
            return ResponseEntity.ok().body(response);
        }
        catch(ResponseException e)
        {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(e.getMessage()));
        }
    }

    @PostMapping("/details")
    public ResponseEntity<?> getReservationDetails(@RequestBody GenericRequest<String> request) {
        try{
            ReservationDto response= reservationService.getReservationByCode(request.getRequestData());
            return ResponseEntity.ok().body(response);
        }
        catch(ResponseException e)
        {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(e.getMessage()));
        }
    }

    @PostMapping("/booking")
    public ResponseEntity<?> makingReservation(@RequestBody ReservationRequest request) {
        try{
            ReservationResponse reservationResponse= reservationService.makeReservation(request);
            return ResponseEntity.ok().body(reservationResponse);
        }
        catch(ResponseException e)
        {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(e.getMessage()));
        }
    }
    @PostMapping("/cancel")
    public ResponseEntity<?> cancelReservation(@RequestBody  CancelRequest request) {
        try{
            CancelResponse response= reservationService.cancelReservation(request);
            return ResponseEntity.ok().body(response);
        }
        catch(ResponseException e)
        {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(e.getMessage()));
        }
    }
}
