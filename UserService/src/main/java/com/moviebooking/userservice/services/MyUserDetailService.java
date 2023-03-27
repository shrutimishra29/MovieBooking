package com.moviebooking.userservice.services;


import com.moviebooking.userservice.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailService implements UserDetailsService {
    
    @Autowired
    private UserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users userByUsername = userService.getUserByUsername(username);

        return new org.springframework.security.core.userdetails.User(userByUsername.getUsername(),
                userByUsername.getPassword(), new ArrayList<>());
    }


}
