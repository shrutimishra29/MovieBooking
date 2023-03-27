package com.moviebooking.theatreservice.responses;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeatsResponse {


    private int seatId;

    private String seatRow;

    private int seatNumber;

    private boolean isReserved;

    private int ticketId;

}
