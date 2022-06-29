package com.example.Flight.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.Flight.model.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Integer> {

    List<Flight> findAll();
    Flight findByFlightId(int id);

}
