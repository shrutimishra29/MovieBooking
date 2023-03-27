package com.moviebooking.theatreservice.services.implementations;

import com.moviebooking.theatreservice.entities.Admin;
import com.moviebooking.theatreservice.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin adminByUsername = adminService.getAdminByUsername(username);

        return new org.springframework.security.core.userdetails.User(adminByUsername.getUsername(),
                adminByUsername.getPassword(), new ArrayList<>());
    }

}

