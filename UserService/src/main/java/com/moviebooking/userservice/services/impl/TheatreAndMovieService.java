package com.moviebooking.userservice.services.impl;

import com.moviebooking.userservice.entities.Movie;
import com.moviebooking.userservice.entities.Theatre;
import com.moviebooking.userservice.external.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TheatreAndMovieService {

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private TheatreService theatreService;


    public List<Theatre> getAllTheatres(){
        return theatreService.getAllTheatre();
    }

    public List<Movie> getAllMoviesByTheaterId(int theatreId){
        return theatreService.getAllMoviesByTheatreId(theatreId);
    }



}
