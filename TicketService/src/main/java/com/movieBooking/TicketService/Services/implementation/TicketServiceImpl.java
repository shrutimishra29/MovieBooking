package com.movieBooking.TicketService.Services.implementation;

import com.movieBooking.TicketService.Services.TicketService;
import com.movieBooking.TicketService.entities.Payment;
import com.movieBooking.TicketService.entities.Seats;
import com.movieBooking.TicketService.entities.Ticket;
import com.movieBooking.TicketService.exceptions.ResourceNotFoundException;
import com.movieBooking.TicketService.external.services.TheatreService;
import com.movieBooking.TicketService.repositories.PaymentRepository;
import com.movieBooking.TicketService.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TheatreService theatreService;

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Ticket createNewTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(int ticketId) {
        Ticket ticketById = ticketRepository.findById(ticketId).orElseThrow(() ->
                new ResourceNotFoundException("Tickets with ticket ID : " + ticketId + " not found"));


        //fetching Seats from THEATRE-SERVICE
        List<Seats> seatsBookedByTicket = theatreService.getSeatsByTicketId(ticketId);
       // ArrayList<Seats> seats = restTemplate.getForObject("")

            ticketById.setBookedSeats(seatsBookedByTicket);
        return ticketById;
    }

    @Override
    public List<Ticket> getTicketByUserId(int userId) {
        List<Ticket> ticketsByUserId = ticketRepository.findAllByUserId(userId);
        if(ticketsByUserId == null){
            throw new ResourceNotFoundException("Tickets with user ID : " + userId + " not found");
        }
        return ticketsByUserId;
    }

    @Override
    public int deleteTicketById(int ticketId) {
        Ticket ticketById = ticketRepository.findById(ticketId).orElseThrow(
                () -> new ResourceNotFoundException("Ticket with id : " + ticketId + " does not exist!!")
        );
        Payment payment = paymentRepository.findById(ticketById.getPaymentId()).orElseThrow(
                () -> new ResourceNotFoundException("Payment with id : " + ticketById.getPaymentId() + " does not exist!!")
        );

        int amount = payment.getPaymentAmount();
        paymentRepository.deleteById(ticketById.getPaymentId());
        ticketRepository.deleteById(ticketId);

        return amount;
    }

}
