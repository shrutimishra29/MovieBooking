package com.moviebooking.userservice.services.impl;

import com.moviebooking.userservice.exceptionhandler.ResourceNotFoundException;
import com.moviebooking.userservice.entities.Payment;
import com.moviebooking.userservice.entities.Ticket;

import com.moviebooking.userservice.entities.Users;
import com.moviebooking.userservice.external.services.TicketService;
import com.moviebooking.userservice.respositories.UserRepository;
import com.moviebooking.userservice.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
            private TicketService ticketService;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        //Implementing TICKET SERVICE call using REST TEMPLATE
        return userRepository.findAll();
    }

    @Override
    public Users getUserByUserId(int userId) {
        Users user =  userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("Admin with given id is not found on the server !! " + userId));


        List<Payment> paymentsOfUser = ticketService.getPaymentByUserId(userId);
        //set Payments for User
        user.setPayments(paymentsOfUser);

        List<Ticket> ticketsOfUser = ticketService.getTicketByUserId(userId);

        //set tickets for user
        user.setTickets(ticketsOfUser);
        return user;
    }

    @Override
    public Users getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
