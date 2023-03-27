package com.moviebooking.theatreservice.services.implementations;

import com.moviebooking.theatreservice.entities.*;
import com.moviebooking.theatreservice.exceptions.ResourceNotFoundException;
import com.moviebooking.theatreservice.repositories.MovieRepository;
import com.moviebooking.theatreservice.repositories.MovieSlotRepository;
import com.moviebooking.theatreservice.requests.MovieRequest;
import com.moviebooking.theatreservice.responses.MovieResponse;
import com.moviebooking.theatreservice.services.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieSlotServiceImpl movieSlotService;
    @Autowired
    private ShowServiceImpl showService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private TheatreServiceImpl theatreService;
    @Autowired
    private MovieSlotRepository movieSlotRepository;

    @Override
    public MovieResponse addMovie(MovieRequest movieRequest) {
              return   modelMapper.map(movieRepository.save(modelMapper.
                              map(movieRequest, Movie.class)),
                        MovieResponse.class);
    }

    //get list of all the movies
    @Override
    public List<MovieResponse> getAllMovies() {

        List<MovieResponse> movieResponses =
                modelMapper.map( movieRepository.findAll(),ArrayList.class);
        return movieResponses;
    }

    //get Movie by id
    @Override
    public Movie getMovieById(int movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() ->
                new ResourceNotFoundException("Movie with id" + movieId + "does not exist."));

        List<MovieSlot> allByMovieId = movieSlotService.findAllByMovieId(movieId);
        List<Show> allShows = new ArrayList<>();

        List<Theatre> theatres = new ArrayList<>();

        for(MovieSlot movieSlot : allByMovieId){
            Show showbyId =  showService.getShowById(movieSlot.getShowId());
            allShows.add(showbyId);
            Theatre theatreById = theatreService.getTheatreById(movieSlot.getTheatreId());
            theatres.add(theatreById);
        }
        movie.setListOfShows(allShows);
        movie.setListOfTheatre(theatres);
        return movie;
    }

}
