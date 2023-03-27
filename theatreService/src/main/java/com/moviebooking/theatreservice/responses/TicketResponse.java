package com.moviebooking.theatreservice.responses;

import com.moviebooking.theatreservice.entities.Seats;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketResponse {
    private int ticketId;
    private int paymentId;
    private int userId;
    private int movieSlotId;
    private List<Seats> bookedSeats;
}
