package com.moviebooking.theatreservice.services.implementations;

import com.moviebooking.theatreservice.entities.Seats;
import com.moviebooking.theatreservice.exceptions.ResourceNotFoundException;
import com.moviebooking.theatreservice.external.services.TicketService;
import com.moviebooking.theatreservice.repositories.SeatsRepository;
import com.moviebooking.theatreservice.services.SeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class SeatsServiceImpl implements SeatsService {

    @Autowired
    SeatsRepository seatsRepository;

    @Autowired
    TicketService ticketService;
    
    @Override
    public Seats createNewSeat(Seats seats) {
        return seatsRepository.save(seats);
    }

    @Override
    public List<Seats> getAllSeats() {
        return seatsRepository.findAll();
    }

    @Override
    public Seats getSeatById(int seatId) {
        return seatsRepository.findById(seatId).orElseThrow(()->
                new ResourceNotFoundException("Seat with Id :" + seatId + " not found"));
    }

    @Override
    public List<Seats> getSeatBySeatRow(char seatRow) {
        return seatsRepository.findAllBySeatRow(seatRow);
    }

    @Override
    public List<Seats> getSeatsByTicketId(int ticketId) {
        List<Seats> seatsByTicketId = seatsRepository.findAllByTicketId(ticketId);
        if(seatsByTicketId == null){
            throw new ResourceNotFoundException("Seats with ticket Id does not exist.");
        }
        return seatsByTicketId;
    }

    @Override
    public void setTicketIdOfSeats(int seatId,int ticketId) {
        seatsRepository.setTicketIdOfSeats(seatId,ticketId);
    }
}
