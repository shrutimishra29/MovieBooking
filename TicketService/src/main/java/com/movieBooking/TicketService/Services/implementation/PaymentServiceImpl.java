package com.movieBooking.TicketService.Services.implementation;

import com.movieBooking.TicketService.Services.PaymentService;
import com.movieBooking.TicketService.entities.Payment;
import com.movieBooking.TicketService.exceptions.ResourceNotFoundException;
import com.movieBooking.TicketService.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getPaymentByUserId(int userId) {
        List<Payment> paymentByUserId = paymentRepository.findAllByUserId(userId);
        if (paymentByUserId == null) {
            throw new ResourceNotFoundException("Payment with userId " + userId + " not found");
        }

        return paymentByUserId;
    }

    @Override
    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

}
