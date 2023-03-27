package com.moviebooking.userservice.constants;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Constants {

    public static final String[] PUBLIC_URLS = {"/users","/users/allTheatre", "/users/TheatreAndMovies","/users/movies/theatre/*",
            "/v3/api-docs","/v3/api-docs/**","/swagger-ui/**","/swagger-resources/**",
            "/webjars/**","/users/*/*","http://theatre-service/theatre/movieSlot/movies/theatre/29"
    };

    public static final long serialVersionUID = -2550185165626488L;

    public static final long JWT_TOKEN_VALIDITY = 5l * 60 * 60;

    public static final String status = "status";

    public static final String message= "message";

    public static final String success = "success";
}
