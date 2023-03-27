package com.moviebooking.theatreservice.services.implementations;

import com.moviebooking.theatreservice.entities.Theatre;
import com.moviebooking.theatreservice.exceptions.ResourceNotFoundException;
import com.moviebooking.theatreservice.repositories.TheatreRepository;
import com.moviebooking.theatreservice.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    @Override
    public Theatre addTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    @Override
    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    @Override
    public Theatre getTheatreById(int id) {
        return theatreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Theatre with given id does not exist."));
    }
}
