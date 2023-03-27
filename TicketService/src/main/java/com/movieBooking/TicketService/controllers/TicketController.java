package com.movieBooking.TicketService.controllers;

import com.movieBooking.TicketService.Services.implementation.TicketServiceImpl;
import com.movieBooking.TicketService.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

    @PostMapping
    public ResponseEntity<Ticket> createNewTicket(@RequestBody Ticket ticket){
        Ticket newTicket = ticketService.createNewTicket(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTicket);
    }

    @GetMapping
    public  ResponseEntity<List<Ticket>> getAllTickets(){
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<Ticket> getAllTicketsById(@PathVariable int ticketId){
        Ticket ticketById = ticketService.getTicketById(ticketId);
        return ResponseEntity.ok(ticketById);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Ticket>> getAllTicketsByUserId(@PathVariable int userId){
        return ResponseEntity.ok(ticketService.getTicketByUserId(userId));
    }


    @DeleteMapping("/cancelReservation/{ticketId}")
    public String cancelTicketById(@PathVariable int ticketId){
        int amount = ticketService.deleteTicketById(ticketId);
        return "Reservation with ticket id :" + ticketId + " has been deleted. Amount" +
                amount + " will be transferred into your account.";
    }

}
