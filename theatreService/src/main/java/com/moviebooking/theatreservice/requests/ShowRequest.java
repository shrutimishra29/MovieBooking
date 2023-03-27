package com.moviebooking.theatreservice.requests;


import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ShowRequest {

    private int showId;


    @Range(min =1, message = "Screen number starts from 1")
    @NotEmpty(message = "screen number should not be null")
    private int screenNumber;


    @NotEmpty(message = "start time should not be null")
    private String startTime;

    @NotEmpty(message = "end time should not be null")
    private String endTime;

}
