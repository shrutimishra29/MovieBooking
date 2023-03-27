package com.moviebooking.theatreservice.services.implementations;

import com.moviebooking.theatreservice.entities.Show;
import com.moviebooking.theatreservice.exceptions.ResourceNotFoundException;
import com.moviebooking.theatreservice.repositories.ShowRepository;
import com.moviebooking.theatreservice.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    ShowRepository showRepository;


    @Override
    public Show addShow(Show show) {
        return showRepository.save(show);
    }

    @Override
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    @Override
    public Show getShowById(int showId) {
        return showRepository.findById(showId).orElseThrow(()-> new ResourceNotFoundException("Show with id "+ showId + " does not exist"));
    }
}
