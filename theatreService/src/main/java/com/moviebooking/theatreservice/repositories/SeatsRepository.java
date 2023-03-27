package com.moviebooking.theatreservice.repositories;

import com.moviebooking.theatreservice.entities.Seats;
import feign.Param;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface SeatsRepository extends JpaRepository<Seats, Integer> {

    public List<Seats> findAllBySeatRow(char seatRow);

    public List<Seats> findAllByTicketId(int ticketId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update theatre_seats set ticket_Id = :ticketId, seat_is_reserved = true WHERE seat_id = :seatId",
    nativeQuery = true)
    void setTicketIdOfSeats(@Param("seatId") int seatId, @Param("ticketId") int ticketId);
}
