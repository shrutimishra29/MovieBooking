package com.moviebooking.theatreservice.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "theatre")
public class Theatre {

    @Id
    @Column(name = "theatre_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int theatreId;

    @NotNull(message = "location should not be null")
    @Column(name = "theatre_location")
    private String theatreLocation;

    @NotNull(message = "name should not be null")
    @Column(name = "theatre_name")
    private String theatreName;

    @Transient
    private List<Movie> listOfMovies = new ArrayList<>();
}
