package com.pbl6.hotelbookingapp.controller;

import com.pbl6.hotelbookingapp.Exception.ResponseException;
import com.pbl6.hotelbookingapp.dto.*;
import com.pbl6.hotelbookingapp.entity.Invoice;
import com.pbl6.hotelbookingapp.service.PaymentService;
import com.pbl6.hotelbookingapp.service.ReservationService;
import com.pbl6.hotelbookingapp.vnpay.Config;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("api/payment")
@RequiredArgsConstructor
@CrossOrigin
public class PaymentController {
    private final PaymentService paymentService;
    private final ReservationService reservationService;
    @PostMapping("/refund")
    public ResponseEntity<?> getRefund(@RequestBody RefundRequest request) throws IOException {

        RefundResponse refundResponse = paymentService.refund(request.getTranType(), request.getOrderId(), request.getPrice(), request.getTransDate(), request.getUser());
        return ResponseEntity.ok().body(refundResponse);
    }
    @PostMapping("/pay")
    public ResponseEntity<?> getPay(@RequestBody ReservationRequest request) throws UnsupportedEncodingException {
        try {

            if(reservationService.checkReservation(request))
            {
                return ResponseEntity.ok().body(paymentService.getPay(request.getVat()));
            }
            else return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("Hotel not found or not enough room!"));
        }
        catch (ResponseException e)
        {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse(e.getMessage()));
        }


    }
    @PostMapping("/invoices")
    public ResponseEntity<?> saveInvoice(@RequestBody SaveInvoiceRequest request)  {
        try {
            Invoice invoice = reservationService.saveInvoice(request);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(invoice);
        }
        catch (ResponseException e)
        {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(e.getMessage()));
        }


    }
}
