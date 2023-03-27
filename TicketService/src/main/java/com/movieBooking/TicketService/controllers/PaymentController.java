package com.movieBooking.TicketService.controllers;

import com.movieBooking.TicketService.Services.implementation.PaymentServiceImpl;
import com.movieBooking.TicketService.entities.Payment;
import com.movieBooking.TicketService.repositories.PaymentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ticket/payment")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;
    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/{numberOfSeats}")
    public ResponseEntity<Payment> newPayment(@Valid @RequestBody Payment payment,@PathVariable int numberOfSeats){
        payment.setNumberOfSeats(numberOfSeats);
        payment.setPaymentAmount(numberOfSeats * 200);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.createPayment(payment));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Payment>> getPaymentByUserId(@PathVariable int userId){
        return ResponseEntity.ok(paymentService.getPaymentByUserId(userId));
    }

    @GetMapping()
    public ResponseEntity<List<Payment>> getAllPayments(){
        List<Payment> allPayment = paymentService.getAllPayment();
        return ResponseEntity.ok(allPayment);
    }
}
