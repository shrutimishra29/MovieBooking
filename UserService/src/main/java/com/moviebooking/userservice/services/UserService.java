package com.moviebooking.userservice.services;

import com.moviebooking.userservice.entities.Users;

import java.util.List;

public interface UserService {

    //user operations

    //create
    Users saveUser(Users user);

    //get all users
    List<Users> getAllUsers();

    //get user by user id
    Users getUserByUserId(int userId);


    Users getUserByUsername(String username);
}
