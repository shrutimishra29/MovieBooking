package com.movieBooking.TicketService.repositories;

import com.movieBooking.TicketService.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    public List<Payment> findAllByUserId(int userId);
}
