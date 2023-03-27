package com.movieBooking.TicketService.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
@Entity
@Table(name = "ticket")
public class Ticket {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ticketId;

    @NotEmpty(message = "Payment id should not be empty")
    @Column(name = "payment_id")
    private int paymentId;

    @NotEmpty(message = "user id should not be empty")
    @Column(name = "user_id")
    private int userId;

    @NotEmpty(message = "movie id should not be empty")
    @Column(name = "movie_slot_id")
    private int movieSlotId;

    @Transient
    private List<Seats> bookedSeats = new ArrayList<>();

}
