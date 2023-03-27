package com.moviebooking.theatreservice;

import com.moviebooking.theatreservice.entities.Show;
import com.moviebooking.theatreservice.services.implementations.ShowServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TheatreServiceApplicationTests {

	@Autowired
	ShowServiceImpl showService;

	@Test
	void contextLoads() {
	}

	@Test
	void createShow(){
		Show show = new Show();
		show.setScreenNumber(1);
		show.setStartTime("9:00 am");
		show.setEndTime("12:00 pm");
		showService.addShow(show);
	}
}
