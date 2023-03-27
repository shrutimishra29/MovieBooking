package com.moviebooking.theatreservice.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Range;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieSlotRequest {


    private int movieSlotId;

    @NotEmpty(message = "movie Id should not be null")
    @Range(min = 1, message = "Choose movie id from list of movies")
    private int movieId;


    @NotEmpty(message = "show id should not be null")
    @Range(min = 152, message = "Choose show Id from list of shows")
    private int showId;

    @NotEmpty(message = "theatre id should not null")
    @Range(min = 1, message = "Choose theatre Id from list of theatres")
    private int theatreId;
}
