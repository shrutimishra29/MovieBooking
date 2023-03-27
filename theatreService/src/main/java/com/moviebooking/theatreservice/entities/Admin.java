package com.moviebooking.theatreservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "admin")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adminId;

    @NotEmpty( message = "admin username should not be null")
    @Column(name = "admin_username")
    private String username;

    @NotEmpty( message = "admin password should not be null")
    @Column(name = "admin_password")
    private String password;
}
