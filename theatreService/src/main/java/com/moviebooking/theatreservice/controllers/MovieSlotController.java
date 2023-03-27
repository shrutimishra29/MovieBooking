package com.moviebooking.theatreservice.controllers;


import com.moviebooking.theatreservice.entities.Movie;
import com.moviebooking.theatreservice.entities.MovieSlot;
import com.moviebooking.theatreservice.responses.MovieResponse;
import com.moviebooking.theatreservice.responses.MovieSlotResponse;
import com.moviebooking.theatreservice.services.implementations.MovieServiceImpl;
import com.moviebooking.theatreservice.services.implementations.MovieSlotServiceImpl;
import com.moviebooking.theatreservice.services.implementations.ShowServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("theatre/movieSlot")
public class MovieSlotController {

    @Autowired
    MovieSlotServiceImpl movieSlotService;

    @Autowired
    MovieServiceImpl movieService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ShowServiceImpl showService;

    @PostMapping
    public ResponseEntity<MovieSlot> createMovieSlot(@RequestBody MovieSlot movieSlot){
        return ResponseEntity.ok(movieSlotService.createMovieSlot(movieSlot));
    }

    @GetMapping
    public ResponseEntity<List<MovieSlot>> getAllMovieSlot(){
        return ResponseEntity.ok(movieSlotService.getAllMovieSlot());
    }


    @GetMapping("/{movieSlotId}")
    public MovieSlotResponse getMovieSlotById(@PathVariable int movieSlotId){
        MovieSlot movieSlotById = movieSlotService.getMovieSlotById(movieSlotId);
        return modelMapper.map(movieSlotById,MovieSlotResponse.class);
    }

    @GetMapping("/movie/{movieId}")
    public MovieSlotResponse getMovieSlotByMovieId(@PathVariable int movieId){
        List<MovieSlot> allByMovieId = movieSlotService.findAllByMovieId(movieId);
        return modelMapper.map(allByMovieId,MovieSlotResponse.class);
    }

    @GetMapping("/theatre/{theatreId}")
    public MovieSlotResponse getMovieSlotByTheatreId(@PathVariable int theatreId){
        List<MovieSlot> allByTheatreId = movieSlotService.findAllByTheatreId(theatreId);
        return modelMapper.map(allByTheatreId,MovieSlotResponse.class);
    }

    @GetMapping("/show/{showId}")
    public MovieSlotResponse getMovieSlotByShowId(@PathVariable int showId){
        List<MovieSlot> allByShowId = movieSlotService.findAllByShowId(showId);
        return modelMapper.map(allByShowId,MovieSlotResponse.class);
    }

    //get all movies by theatre id
    @GetMapping("/movies/theatre/{theatreId}")
    public MovieResponse getMoviesByTheatreId(@PathVariable int theatreId){
        List<MovieSlot> movieSlotsByTheatreId = movieSlotService.findAllByTheatreId(theatreId);
        List<Movie> allMoviesByTheatreId = new ArrayList<>();
        for(MovieSlot movieSlot: movieSlotsByTheatreId) {
            allMoviesByTheatreId.add(movieService.getMovieById(movieSlot.getMovieId()));
        }
        return modelMapper.map(allMoviesByTheatreId,MovieResponse.class);
    }

}
