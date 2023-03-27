package com.moviebooking.theatreservice.controllers;


import com.moviebooking.theatreservice.entities.Movie;
import com.moviebooking.theatreservice.entities.MovieSlot;
import com.moviebooking.theatreservice.entities.Theatre;
import com.moviebooking.theatreservice.responses.TheatreResponse;
import com.moviebooking.theatreservice.services.implementations.MovieServiceImpl;
import com.moviebooking.theatreservice.services.implementations.MovieSlotServiceImpl;
import com.moviebooking.theatreservice.services.implementations.TheatreServiceImpl;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    private TheatreServiceImpl theatreService;

    @Autowired
    MovieSlotServiceImpl movieSlotService;

    @Autowired
    MovieServiceImpl movieService;

    @Autowired
    Random random;

    @Autowired
    ModelMapper modelMapper;

    //add theatre
    @PostMapping
    public TheatreResponse addTheatre(@Valid @RequestBody Theatre theatre){
        int randomID = random.nextInt();
        theatre.setTheatreId(randomID);
        Theatre addTheatre = theatreService.addTheatre(theatre);

        return modelMapper.map(addTheatre,TheatreResponse.class);
    }


    //Get details of theatre by theatre id
    @GetMapping("/{theatreId}")
    public TheatreResponse getTheatreById(@PathVariable int theatreId){
        Theatre theatre = theatreService.getTheatreById(theatreId);
        List<Movie> moviesAtTheatre = new ArrayList<>();
        List<MovieSlot> allSlotsByTheatreId = movieSlotService.findAllByTheatreId(theatreId);
        for (MovieSlot movieSlot : allSlotsByTheatreId) {
            moviesAtTheatre.add(movieService.getMovieById(movieSlot.getMovieId()));
        }

        theatre.setListOfMovies(moviesAtTheatre);

        return modelMapper.map(theatre,TheatreResponse.class);
    }

    //get details of all the theatres

    @GetMapping()
    public TheatreResponse getAllTheatres(){
        List<Theatre> allTheatres = theatreService.getAllTheatres();
        return modelMapper.map(allTheatres,TheatreResponse.class);
    }

    @Bean
    public Random random(){
        return new Random();
    }
}
