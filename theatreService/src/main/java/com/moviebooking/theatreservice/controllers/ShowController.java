package com.moviebooking.theatreservice.controllers;

import com.moviebooking.theatreservice.entities.Show;
import com.moviebooking.theatreservice.responses.ShowResponse;
import com.moviebooking.theatreservice.services.implementations.ShowServiceImpl;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("theatre/shows")
public class ShowController {

    @Autowired
    ShowServiceImpl showService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Show> createShow(@Valid @RequestBody Show show){
        Show savedShow = showService.addShow(show);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedShow);
    }

    @GetMapping
    public ShowResponse getAllShows(){
        List<Show> allShows = showService.getAllShows();
        return modelMapper.map(allShows, ShowResponse.class);
    }

    @GetMapping("/{showId}")
    public ShowResponse getShowById(@PathVariable int showId){
        Show showById = showService.getShowById(showId);
        return modelMapper.map(showById,ShowResponse.class);
    }

}
