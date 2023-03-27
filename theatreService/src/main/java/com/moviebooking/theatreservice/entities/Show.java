package com.moviebooking.theatreservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "movie_show")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "showId")
    private int showId;


    @Range(min =1, message = "Screen number starts from 1")
    @NotEmpty(message = "screen number should not be null")
    @Column(name = "screen_number")
    private int screenNumber;


    @NotEmpty(message = "start time should not be null")
    @Column(name = "start_time")
    private String startTime;

    @NotEmpty(message = "end time should not be null")
    @Column(name = "end_time")
    private String endTime;

}
