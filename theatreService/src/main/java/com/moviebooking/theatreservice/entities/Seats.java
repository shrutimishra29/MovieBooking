package com.moviebooking.theatreservice.entities;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Range;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "theatre_seats")
public class Seats {

    @Id
    @Column(name = "seat_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seatId;


    @Size(min = 1, max = 1)
    @NotEmpty(message = "seat row should not be empty")
    @Column(name = "seat_row")
   private String seatRow;

    @Range(min = 1, max = 5, message = "Seat number should be between 1 and 5")
    @Column(name = "seat_number")
   private int seatNumber;


    @Column(name = "seat_isReserved")
    private boolean isReserved;


   @Column(name = "ticket_id")
    private int ticketId;

}
