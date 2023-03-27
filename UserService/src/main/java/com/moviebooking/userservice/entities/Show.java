package com.moviebooking.userservice.entities;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Show {

    private int showId;

    private int screenNumber;

    private String startTime;

    private String endTime;

}
