package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.dto.*;
import com.pbl6.hotelbookingapp.entity.*;
import io.jsonwebtoken.io.IOException;
import jakarta.transaction.Transactional;

import java.time.temporal.ChronoUnit;
import java.util.*;

public interface ReservationService {
    boolean checkReservation(ReservationRequest request);

    ReservationResponse makeReservation(ReservationRequest request);

    ReservationDto getReservationByCode(String reservationCode);


    ReservedHistoryResponse getHistory(String token);

    Invoice saveInvoice(SaveInvoiceRequest request);

    @Transactional
    CancelResponse cancelReservation(CancelRequest request) throws IOException;
}
