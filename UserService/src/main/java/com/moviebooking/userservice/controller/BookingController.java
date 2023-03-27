package com.moviebooking.userservice.controller;


import com.moviebooking.userservice.exceptionhandler.ResourceNotFoundException;
import com.moviebooking.userservice.entities.Payment;
import com.moviebooking.userservice.entities.Ticket;
import com.moviebooking.userservice.external.services.TicketService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users/booking")
@Slf4j
public class BookingController {

    @Autowired
    private TicketService ticketService;


    @PostMapping("/newPayment/{numberOfSeats}")
    public Payment newPayment(@PathVariable int numberOfSeats){
        return ticketService.newPayment(numberOfSeats);
    }

    @PostMapping("/newTicket")
    public Ticket newTicket(@RequestBody Ticket ticket){
       return ticketService.newTicket(ticket);
    }

    int retryCount = 1;
    @CircuitBreaker(name ="userTicketCircuitBreaker", fallbackMethod = "userTicketFallback")
    @GetMapping("/ticket/users/{userId}")
    public List<Ticket> getTicketsByUserId(@PathVariable int userId){
        log.info("Retry count {}", retryCount);
        retryCount++;

        List<Ticket> ticketByUserId = ticketService.getTicketByUserId(userId);
        if(ticketByUserId == null){
            throw new ResourceNotFoundException("No tickets found by User with userId : " + userId);
        }

        return ticketByUserId;
    }



    //Creating fallback method for circuit Breaker
    public List<Ticket> userTicketFallback(int userId, Exception ex){

        log.info("Fallback is excepted as service is down: "+ ex.getMessage());
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(Ticket.builder().ticketId(00).bookedSeats(null).movieId(00).showId(00).showId(00)
                .paymentId(00).build());

        return tickets;
    }
}
