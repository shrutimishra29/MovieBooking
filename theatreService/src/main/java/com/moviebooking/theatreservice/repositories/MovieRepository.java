package com.moviebooking.theatreservice.repositories;

import com.moviebooking.theatreservice.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
