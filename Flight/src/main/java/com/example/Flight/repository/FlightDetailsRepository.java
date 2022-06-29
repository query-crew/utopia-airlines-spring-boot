package com.example.Flight.repository;

import java.util.List;

import com.example.Flight.model.FlightDetails;
import org.springframework.data.repository.CrudRepository;

public interface FlightDetailsRepository extends CrudRepository<FlightDetails, String> {

    List<FlightDetails> findAll();
    FlightDetails findByFlightNumber(String flightNumber);

}