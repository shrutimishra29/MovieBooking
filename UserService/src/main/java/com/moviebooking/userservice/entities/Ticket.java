package com.moviebooking.userservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "ticket")
public class Ticket {


    @Id
    private int ticketId;

    @Column(name = "payment_id", nullable = false)
    private int paymentId;

    @Column(name = "show_id")
    private int showId;


    @Column(name = "user_id")
    private int userId;

    @Column(name = "movie_id")
    private int movieId;


    @Transient
    private List<Seats> bookedSeats = new ArrayList<>();

}
