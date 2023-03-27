package com.moviebooking.theatreservice.controllers;

import com.moviebooking.theatreservice.entities.Seats;
import com.moviebooking.theatreservice.responses.SeatsResponse;
import com.moviebooking.theatreservice.services.implementations.SeatsServiceImpl;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("theatre/seats")
public class SeatController {

    @Autowired
    SeatsServiceImpl seatsService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Seats> createNewSeat(@Valid @RequestBody Seats seats) {
        seats.setReserved(false);
        Seats newSeat = seatsService.createNewSeat(seats);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSeat);
    }

    @GetMapping
    public ResponseEntity<List<Seats>> getAllSeats(){
        return ResponseEntity.ok(seatsService.getAllSeats());
    }

    @GetMapping("/{seatId}")
    public SeatsResponse getSeatById(@PathVariable int seatId){
        Seats seatById = seatsService.getSeatById(seatId);
        return modelMapper.map(seatById,SeatsResponse.class);
    }

    @GetMapping("/seatRow/{seatRow}")
    public SeatsResponse getSeatBySeatRow(@PathVariable char seatRow){
        List<Seats> seatBySeatRow = seatsService.getSeatBySeatRow(seatRow);
        return modelMapper.map(seatBySeatRow,SeatsResponse.class);
    }

    @GetMapping("/ticket/{ticketId}")
    public SeatsResponse getSeatsByTicketId(@PathVariable int ticketId){
        List<Seats> seatsByTicketId = seatsService.getSeatsByTicketId(ticketId);
        return modelMapper.map(seatsByTicketId,SeatsResponse.class);
    }

    @PutMapping("/{seatId}/ticket/{ticketId}")
    public void setTicketIdOfSeats(@PathVariable int seatId, @PathVariable int ticketId){
        seatsService.setTicketIdOfSeats(seatId,ticketId);
    }

}
