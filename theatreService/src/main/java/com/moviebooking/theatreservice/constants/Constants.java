package com.moviebooking.theatreservice.constants;


public class Constants {

    public static final String[] PUBLIC_URLS = {"/theatre/movies","/theatre/movieSlot", "/theatre/seats","/theatre/shows","/theatre/theatre",
            "/theatre/movies/*","/theatre/movieSlot/*", "/theatre/seats/*" ,"/theatre/shows/*","/theatre/*","/theatre/movieSlot/movies/theatre/*",
            "/seats/ticket/*","/v3/api-docs","/v3/api-docs/**","/swagger-ui/**","/swagger-resources/**",
            "/webjars/**","/actuator/health","/actuator/*","/actuator"
    };


    public static final long JWT_TOKEN_VALIDITY = 5l * 60 * 60;

    public static final String status = "status";

    public static final String message= "message";

    public static final String success = "success";

    public static final String SECRET_KEY = "secret";

}
