package com.pbl6.hotelbookingapp.email;

import com.pbl6.hotelbookingapp.dto.CancelResponse;
import com.pbl6.hotelbookingapp.dto.ReservationResponse;
import com.pbl6.hotelbookingapp.entity.Hotel;
import com.pbl6.hotelbookingapp.entity.User;

public interface EmailService {
    void sendSimpleMailMessage(String name, String to, String token);

    void sendReservationConfirmationEmail(ReservationResponse reservationResponse, String to);
    void sendHtmlEmail(String name, String to, String token);
    public void sendCancellationEmail(CancelResponse cancelResponse, String to);
    void sendDeclineNotification(User user, Hotel hotel);
    void sendApprovalNotification(User user, Hotel hotel);


}
