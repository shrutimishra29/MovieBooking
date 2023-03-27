package com.moviebooking.theatreservice.services;

import com.moviebooking.theatreservice.entities.Seats;

import java.util.List;

public interface SeatsService {

    //create new seat
    public Seats createNewSeat(Seats seats);

    //get all seats
    public List<Seats> getAllSeats();

    //get seat by seat Id
    public Seats getSeatById(int seatId);

    //get seat by seat Row
    public List<Seats> getSeatBySeatRow(char seatRow);

    //get Seats by Ticket Id
    public List<Seats> getSeatsByTicketId(int ticketId);


    //update ticket id and set isReserved to true
    void setTicketIdOfSeats(int seatId, int ticketId);

}
