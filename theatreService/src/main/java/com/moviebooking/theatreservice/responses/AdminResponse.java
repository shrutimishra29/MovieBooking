package com.moviebooking.theatreservice.responses;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serializable;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminResponse implements Serializable {
    private int adminId;

    private String username;

    private String password;
}
