package com.moviebooking.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Theatre {

    private int theatreId;

    private String theatreLocation;

    private String theatreName;

    private List<Movie> listOfMovies = new ArrayList<>();
}
