package com.moviebooking.theatreservice.requests;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminRequest implements Serializable {

    private int adminId;

    @NotEmpty( message = "admin username should not be null")
    @Column(name = "admin_username")
    private String username;

    @NotEmpty( message = "admin password should not be null")
    @Column(name = "admin_password")
    private String password;
}
