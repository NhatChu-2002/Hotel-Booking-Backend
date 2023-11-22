package com.pbl6.hotelbookingapp.email;

import com.pbl6.hotelbookingapp.dto.CancelResponse;
import com.pbl6.hotelbookingapp.dto.ReservationResponse;

public interface EmailService {
    void sendSimpleMailMessage(String name, String to, String token);

    void sendReservationConfirmationEmail(ReservationResponse reservationResponse, String to);
    void sendHtmlEmail(String name, String to, String token);
    public void sendCancellationEmail(CancelResponse cancelResponse, String to);

}
