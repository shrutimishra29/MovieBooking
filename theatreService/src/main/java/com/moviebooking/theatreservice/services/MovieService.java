package com.moviebooking.theatreservice.services;

import com.moviebooking.theatreservice.entities.Movie;
import com.moviebooking.theatreservice.requests.MovieRequest;
import com.moviebooking.theatreservice.responses.MovieResponse;

import java.util.List;

public interface MovieService {

    //add movies to database
    public MovieResponse addMovie(MovieRequest movieRequest);

    //get all movies
    public List<MovieResponse> getAllMovies();

    //get movie by id
    public Movie getMovieById(int movieId);
}
