package com.moviebooking.theatreservice.services;

import com.moviebooking.theatreservice.entities.Show;
import java.util.List;

public interface ShowService {

    //to add show
    public Show addShow(Show show);

    //to get all shows
    public List<Show> getAllShows();

    //find Show by Id

   public Show getShowById(int showId);
}
