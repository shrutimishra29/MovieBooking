package com.moviebooking.theatreservice.responses;

import com.moviebooking.theatreservice.entities.Show;
import com.moviebooking.theatreservice.entities.Theatre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponse {

    private int movieId;

    private String movieName;

    private String movieLanguage;

    private int movieDuration;

    private int showId;

    private List<Show> listOfShows;

    private List<Theatre> listOfTheatre;
}
