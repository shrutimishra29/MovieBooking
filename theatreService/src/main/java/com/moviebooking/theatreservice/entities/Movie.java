package com.moviebooking.theatreservice.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "theatre_movie")
public class Movie {

    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieId;

    @NotEmpty(message = "movie name should not be null")
    @Column(name = "movie_name")
    private String movieName;

    @NotEmpty(message = "movie Language should not be null")
    @Column(name = "movie_language")
    private String movieLanguage;

    @Range(min = 1, max = 3, message = "Movie should be minimum 1 hour long and maximum 3 hours.")
    @Column(name = "movie_duration")
    private int movieDuration;

   @Range(min = 152, message = "Choose show id from all the shows present.")
    @Column(name = "show_id")
    private int showId;

    @Transient
    private List<Show> listOfShows = new ArrayList<>();

    @Transient
    private List<Theatre> listOfTheatre = new ArrayList<>();
}
