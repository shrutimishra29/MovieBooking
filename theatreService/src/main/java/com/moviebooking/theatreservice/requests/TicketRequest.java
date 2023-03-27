package com.moviebooking.theatreservice.requests;

import com.moviebooking.theatreservice.entities.Seats;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketRequest {


    private int ticketId;


    private int paymentId;

    private int userId;


    private int movieSlotId;


    private List<Seats> bookedSeats = new ArrayList<>();
}
