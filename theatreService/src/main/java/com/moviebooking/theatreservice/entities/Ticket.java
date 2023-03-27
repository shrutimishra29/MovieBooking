package com.moviebooking.theatreservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ticket {

    private int ticketId;


    private int paymentId;

    private int userId;


    private int movieSlotId;


    private List<Seats> bookedSeats = new ArrayList<>();
}