package com.movieBooking.TicketService.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;


    @Column(name = "payment_amount")
    private int paymentAmount;

   @NotEmpty(message = "User Id should not be empty")
    @Column(name = "user_ids")
    private int userId;

    @Transient
    private int numberOfSeats;


}
