package com.moviebooking.theatreservice.external.services;

import com.moviebooking.theatreservice.entities.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "TICKET-SERVICE")
public interface TicketService {

    @GetMapping("/ticket/{ticketId}")
    public Ticket getTicketById(@PathVariable int ticketId);


}
