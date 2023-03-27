package com.moviebooking.theatreservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "movie_slots")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovieSlot {

    @Id
    @Column(name = "movie_slot_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieSlotId;

    @NotEmpty(message = "movie Id should not be null")
    @Range(min = 1, message = "Choose movie id from list of movies")
    @Column(name = "slot_movie_id")
    private int movieId;


    @NotEmpty(message = "show id should not be null")
    @Range(min = 152, message = "Choose show Id from list of shows")
    @Column(name = "slot_show_id")
    private int showId;

    @NotEmpty(message = "theatre id should not null")
    @Range(min = 1, message = "Choose theatre Id from list of theatres")
    @Column(name = "slot_theatre_id")
    private int theatreId;

}
