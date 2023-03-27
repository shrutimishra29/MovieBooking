package com.moviebooking.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private int movieId;

    private String movieName;

    private String movieLanguage;

    private int movieDuration;

    private int showId;

    private List<Show> listOfShows = new ArrayList<>();

    private List<Theatre> listOfTheatre = new ArrayList<>();
}
