package com.movieBooking.TicketService.repositories;


import com.movieBooking.TicketService.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    public List<Ticket> findAllByUserId(int userId);
}
