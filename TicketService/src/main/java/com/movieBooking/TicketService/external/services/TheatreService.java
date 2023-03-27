package com.movieBooking.TicketService.external.services;


import com.movieBooking.TicketService.entities.Seats;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "THEATRE-SERVICE")
public interface TheatreService {

    @GetMapping("theatre/seats/ticket/{ticketId}")
    public List<Seats> getSeatsByTicketId(@PathVariable int ticketId);

}
