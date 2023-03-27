package com.moviebooking.theatreservice.repositories;


import com.moviebooking.theatreservice.entities.MovieSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieSlotRepository extends JpaRepository<MovieSlot, Integer> {

    // To find all movieSlots by movie id
    public List<MovieSlot> findAllByMovieId(int movieId);

    // To find all movieSlots by Slot id
    public List<MovieSlot> findAllByShowId(int showId);

    //To find all movie slots by theatre id
    public List<MovieSlot> findALlByTheatreId(int theatreId);
}
