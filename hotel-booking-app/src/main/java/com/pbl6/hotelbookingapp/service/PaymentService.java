package com.pbl6.hotelbookingapp.service;

import com.pbl6.hotelbookingapp.dto.RefundResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface PaymentService {
    RefundResponse refund(String tranType, String orderId, Double price, String transDate, String user) throws IOException;

    String getPay(Double price) throws UnsupportedEncodingException;
}
