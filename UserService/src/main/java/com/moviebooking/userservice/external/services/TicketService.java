package com.moviebooking.userservice.external.services;

import com.moviebooking.userservice.entities.Payment;
import com.moviebooking.userservice.entities.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "TICKET-SERVICE")
public interface TicketService {

    @GetMapping("/ticket/users/{userId}")
    List<Ticket> getTicketByUserId(@PathVariable int userId);

    @GetMapping("ticket/payment/users/{userId}")
    List<Payment> getPaymentByUserId(@PathVariable int userId);

    @PostMapping("ticket/payment/{numberOfSeats}")
    Payment newPayment(@PathVariable int numberOfSeats);

    @PostMapping("/ticket")
    Ticket newTicket(Ticket ticket);
}
