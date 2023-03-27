package com.moviebooking.theatreservice.requests;

import com.moviebooking.theatreservice.entities.Movie;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TheatreRequest {

    private int theatreId;

    @NotNull(message = "location should not be null")
    private String theatreLocation;

    @NotNull(message = "name should not be null")
    private String theatreName;

    private List<Movie> listOfMovies = new ArrayList<>();
}
