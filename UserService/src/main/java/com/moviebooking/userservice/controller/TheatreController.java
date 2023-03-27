package com.moviebooking.userservice.controller;

import com.moviebooking.userservice.entities.Movie;
import com.moviebooking.userservice.entities.Theatre;
import com.moviebooking.userservice.services.impl.TheatreAndMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class TheatreController {

    @Autowired
    private TheatreAndMovieService theatreAndMovieService;


    @GetMapping("/allTheatre")
    public List<Theatre> getAllTheatre(){
        return theatreAndMovieService.getAllTheatres();
    }

    @GetMapping("/movies/theatre/{theatreId}")
    public List<Movie> getAllMovies(@PathVariable int theatreId){
         return theatreAndMovieService.getAllMoviesByTheaterId(theatreId);
    }


}
