package com.moviebooking.userservice.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_costumer")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;

   @NotEmpty(message = "name should not be null")
    @Column(name = "user_name")
    private String username;

    @Email
    @NotNull(message = "email should not be null")
    @Column(name = "user_email")
    private String userEmail;

     @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z]).{6,8}$", message = "Minimum 6 and Maximum 8 Character.\n" +
             "Atleast 1 number, 1 alphabet in capitals and No Special char allowed.")
    @NotEmpty(message = "password cannot be null")
    @Column(name = "user_password")
    private String password;

    @Min(value = 18, message = "user should be above 18 years of age.")
    @Column(name = "_age")
    private int userAge;

     @Transient
    private List<Ticket> tickets = new ArrayList<>();

     @Transient
    private List<Payment> payments = new ArrayList<>();


}
