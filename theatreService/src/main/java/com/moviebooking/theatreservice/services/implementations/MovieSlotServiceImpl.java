package com.moviebooking.theatreservice.services.implementations;

import com.moviebooking.theatreservice.entities.MovieSlot;
import com.moviebooking.theatreservice.exceptions.ResourceNotFoundException;
import com.moviebooking.theatreservice.repositories.MovieSlotRepository;
import com.moviebooking.theatreservice.services.MovieSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieSlotServiceImpl implements  MovieSlotService{

    @Autowired
    MovieSlotRepository movieSlotRepository;

    @Override
    public MovieSlot createMovieSlot(MovieSlot movieSlot) {
        return movieSlotRepository.save(movieSlot);
    }

    @Override
    public List<MovieSlot> getAllMovieSlot() {
        return movieSlotRepository.findAll();
    }

    @Override
    public MovieSlot getMovieSlotById(int movieSlotId) {
        return movieSlotRepository.findById(movieSlotId).orElseThrow(()->
                new ResourceNotFoundException("Movie Slot with id :" + movieSlotId +" not found"));
    }

    @Override
    public List<MovieSlot> findAllByMovieId(int movieId) {
        List<MovieSlot> movieSlotsByMovieId = movieSlotRepository.findAllByMovieId(movieId);
        if(movieSlotsByMovieId == null){
            throw new ResourceNotFoundException("Movie Slot with given movieId : " + movieId + " not found");
        }

        return movieSlotsByMovieId;
    }

    @Override
    public List<MovieSlot> findAllByShowId(int showId) {
        return movieSlotRepository.findAllByShowId(showId);
    }

    @Override
    public List<MovieSlot> findAllByTheatreId(int theatreId) {
        return movieSlotRepository.findALlByTheatreId(theatreId);
    }


}
