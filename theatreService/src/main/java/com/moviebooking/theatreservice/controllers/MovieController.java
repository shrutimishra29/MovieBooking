package com.moviebooking.theatreservice.controllers;


import com.moviebooking.theatreservice.entities.Movie;
import com.moviebooking.theatreservice.entities.MovieSlot;
import com.moviebooking.theatreservice.entities.Show;
import com.moviebooking.theatreservice.entities.Theatre;
import com.moviebooking.theatreservice.requests.MovieRequest;
import com.moviebooking.theatreservice.responses.MovieResponse;
import com.moviebooking.theatreservice.services.implementations.MovieServiceImpl;
import com.moviebooking.theatreservice.services.implementations.MovieSlotServiceImpl;
import com.moviebooking.theatreservice.services.implementations.ShowServiceImpl;
import com.moviebooking.theatreservice.services.implementations.TheatreServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("theatre/movies")
@Slf4j
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;

    @Autowired
    ShowServiceImpl showService;

    @Autowired
    MovieSlotServiceImpl movieSlotService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    TheatreServiceImpl theatreService;
    @PostMapping
    @Operation(
            description = "Used to add movie to database",
            responses = {
                    @ApiResponse(responseCode = "400",description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized access"),
                    @ApiResponse(responseCode = "200", description = "Successful Operation"),
                    @ApiResponse(responseCode = "500",description = "Server Error")
            }
    )
    public MovieResponse addMovie(@Valid @RequestBody MovieRequest movieRequest){
        return movieService.addMovie(movieRequest);
    }

    @GetMapping
    @Operation(
            description = "Used to retrieve all Movies",
            responses = {
                    @ApiResponse(responseCode = "400",description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized access"),
                    @ApiResponse(responseCode = "200", description = "Successful Operation"),
                    @ApiResponse(responseCode = "500",description = "Server Error")
            }
    )
    public List<MovieResponse> getAllMovies(){
        List<MovieResponse> allMovies = movieService.getAllMovies();
        if(allMovies == null){
            log.error("No movies available");
        }
        else{
            log.info("Details of all movies have been sent.");
        }
        return allMovies;
    }

    @Operation(
            description = "Used to get movie by movieId",
            responses = {
                    @ApiResponse(responseCode = "400",description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized access"),
                    @ApiResponse(responseCode = "200", description = "Successful Operation"),
                    @ApiResponse(responseCode = "500",description = "Server Error")
            }
    )
    @GetMapping("/{movieId}")
    public MovieResponse getMovieById(@PathVariable int movieId){
        List<Show> allShowOfMovie = new ArrayList<>();
        List<MovieSlot> allMovieSlotsByMovieId = movieSlotService.findAllByMovieId(movieId);
        for (MovieSlot movieSlot : allMovieSlotsByMovieId) {
            int showId = movieSlot.getShowId();
            Show showById = showService.getShowById(showId);
            allShowOfMovie.add(showById);
        }
        Movie movie = movieService.getMovieById(movieId);

        movie.setListOfShows(allShowOfMovie);

        List<Theatre> allTheatreShowingMovie = new ArrayList<>();
        for (MovieSlot movieSlot : allMovieSlotsByMovieId) {
            allTheatreShowingMovie.add(theatreService.getTheatreById( movieSlot.getTheatreId()));
        }

        movie.setListOfTheatre(allTheatreShowingMovie);

        return modelMapper.map(movie, MovieResponse.class);
    }

}
