package com.moviebooking.userservice.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Seats {


    private int seatId;


    private int seatRow;

    private int seatColumn;

    private int seatNumber;

    private boolean isReserved;

    private int ticketId;
}
