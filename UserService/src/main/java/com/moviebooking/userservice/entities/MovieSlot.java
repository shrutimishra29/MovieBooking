package com.moviebooking.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovieSlot {

    private int movieSlotId;

    private int movieId;

    private int showId;

    private int theatreId;

}
