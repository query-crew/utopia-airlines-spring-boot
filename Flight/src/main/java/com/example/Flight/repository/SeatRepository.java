package com.example.Flight.repository;

import java.util.List;

import com.example.Flight.model.Seat;
import org.springframework.data.repository.CrudRepository;

public interface SeatRepository extends CrudRepository<Seat, Integer> {

    List<Seat> findAll();
    Seat findBySeatId(int seatId);

}