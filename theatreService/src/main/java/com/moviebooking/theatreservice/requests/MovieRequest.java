package com.moviebooking.theatreservice.requests;

import com.moviebooking.theatreservice.entities.Show;
import com.moviebooking.theatreservice.entities.Theatre;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {

    private int movieId;

    @NotEmpty(message = "movie name should not be null")
    private String movieName;

    @NotEmpty(message = "movie Language should not be null")
    private String movieLanguage;

    @Range(min = 1, max = 3, message = "Movie should be minimum 1 hour long and maximum 3 hours.")
    private int movieDuration;

    @Range(min = 152, message = "Choose show id from all the shows present.")
    private int showId;

    private List<Show> listOfShows = new ArrayList<>();


    private List<Theatre> listOfTheatre = new ArrayList<>();
}
