package com.movieBooking.TicketService.Services;

import com.movieBooking.TicketService.entities.Payment;

import java.util.List;

public interface PaymentService {

    //to create new payment
    public Payment createPayment(Payment payment);

    //get Payment by UserId
    public List<Payment> getPaymentByUserId(int userId);

    //Get all payment
    public List<Payment> getAllPayment();

}
