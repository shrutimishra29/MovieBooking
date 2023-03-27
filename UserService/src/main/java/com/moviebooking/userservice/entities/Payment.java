package com.moviebooking.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Payment {


    private int paymentId;

    private int paymentAmount;

    private int userId;

    private int numberOfSeats;


}
