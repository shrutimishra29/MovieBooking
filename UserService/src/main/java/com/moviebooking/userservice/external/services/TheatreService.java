package com.moviebooking.userservice.external.services;

import com.moviebooking.userservice.entities.Movie;
import com.moviebooking.userservice.entities.Theatre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "THEATRE-SERVICE")
public interface TheatreService {

    @GetMapping("theatre/movies")
    public List<Movie> getAllMovies();

    @GetMapping("/theatre")
    public List<Theatre> getAllTheatre();

    @GetMapping("theatre/movieSlot/movies/theatre/{theatreId}")
    public List<Movie> getAllMoviesByTheatreId(@PathVariable int theatreId);

}
