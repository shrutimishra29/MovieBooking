package com.moviebooking.theatreservice.services;
import com.moviebooking.theatreservice.entities.MovieSlot;

import java.util.List;

public interface MovieSlotService {

    //create movie Slot
    public MovieSlot createMovieSlot(MovieSlot movieSlot);

    //get all Movie Slots
    public List<MovieSlot> getAllMovieSlot();


    //get Movie Slot by id
    public MovieSlot getMovieSlotById(int movieSlotId);

    // To find all movieSlots by movie id
    public List<MovieSlot> findAllByMovieId(int movieId);

    // To find all movieSlots by Slot id
    public List<MovieSlot> findAllByShowId(int showId);

  //  To find all movie slots by theatre id
    public List<MovieSlot> findAllByTheatreId(int theatreId);

}
