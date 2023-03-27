package com.moviebooking.theatreservice.responses;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieSlotResponse {

    private int movieSlotId;

    private int movieId;

    private int showId;

    private int theatreId;
}
