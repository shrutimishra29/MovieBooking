package com.moviebooking.theatreservice.responses;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowResponse {


    private int showId;

    private int screenNumber;

    private String startTime;

    private String endTime;
}
