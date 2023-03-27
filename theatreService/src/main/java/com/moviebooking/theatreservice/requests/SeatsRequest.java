package com.moviebooking.theatreservice.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Range;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SeatsRequest {

    private int seatId;


    @Size(min = 1, max = 1)
    @NotEmpty(message = "seat row should not be empty")
    private String seatRow;

    @Range(min = 1, max = 5, message = "Seat number should be between 1 and 5")
    private int seatNumber;

    private boolean isReserved;

    private int ticketId;

}
