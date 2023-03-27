package com.moviebooking.theatreservice.services;

import com.moviebooking.theatreservice.entities.Theatre;

import java.util.List;

public interface TheatreService {

    //Admin can add theatre
    Theatre addTheatre(Theatre theatre);

    //Users and admin can see the list of all theatres
    List<Theatre> getAllTheatres();

    //get single hotel using it's ID

    Theatre getTheatreById(int id);
}
