package com.moviebooking.userservice.controller;

import com.moviebooking.userservice.entities.Users;
import com.moviebooking.userservice.respositories.UserRepository;
import com.moviebooking.userservice.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    //create user role Admin
    @PostMapping
    public Users createUser(@RequestBody Users user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.saveUser(user);
    }


    //get user by userid
    @GetMapping("/{userId}")
    public ResponseEntity<Users> getSingleUser(@PathVariable int userId){
        Users user = userService.getUserByUserId(userId);
        return ResponseEntity.ok(user);
    }


    //get all users
    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/username/{username}")
    public Users getUserByUsername(@PathVariable  String username){
        return userService.getUserByUsername(username);
    }

}
