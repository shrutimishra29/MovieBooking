package com.moviebooking.theatreservice.repositories;

import com.moviebooking.theatreservice.entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show,Integer> {
}
