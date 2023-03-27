package com.movieBooking.TicketService.Services;

import com.movieBooking.TicketService.entities.Ticket;

import java.util.List;

public interface TicketService {

    //create a new ticket
    public Ticket createNewTicket(Ticket ticket);

    //get all tickets
    public List<Ticket> getAllTickets();

    //get tickets by ticket id
    public Ticket getTicketById(int ticketId);

    //get tickets by user id
    public List<Ticket> getTicketByUserId(int userId);

    public int deleteTicketById(int ticketId);
}
