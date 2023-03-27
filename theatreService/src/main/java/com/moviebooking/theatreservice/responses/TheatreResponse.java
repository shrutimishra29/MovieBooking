package com.moviebooking.theatreservice.responses;

import com.moviebooking.theatreservice.entities.Movie;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TheatreResponse {


    private int theatreId;

    private String theatreLocation;

    private String theatreName;

    private List<Movie> listOfMovies;
}
