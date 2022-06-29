package com.example.Flight.controller;

import com.example.Flight.model.Flight;
import com.example.Flight.model.FlightDetails;
import com.example.Flight.model.Seat;
import com.example.Flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class FlightController {

    @Autowired
    FlightService flightService;

    // Create
    @RequestMapping(path = "/flight", method = RequestMethod.POST)
    public void addNewFlight(@RequestBody Flight flight) {
        flightService.addFlight(flight);
    }

    @RequestMapping(path = "/flight/flight-details", method = RequestMethod.POST)
    public void addNewFlightDetails(@RequestBody FlightDetails flightDetails) {
        flightService.addFlightDetails(flightDetails);
    }

    @RequestMapping(path = "/flight/seat", method = RequestMethod.POST)
    public void addNewSeat(@RequestBody Seat seat) {
        flightService.addSeat(seat);
    }

    // Read
    // All
    @RequestMapping(path = "/flight", method = RequestMethod.GET)
    public List<Flight> findFlights() {
        return flightService.findAllFlights();
    }

    @RequestMapping(path = "/flight/flight-details", method = RequestMethod.GET)
    public List<FlightDetails> findFlightDetails() {
        return flightService.findAllFlightDetails();
    }

    @RequestMapping(path = "/flight/seat", method = RequestMethod.GET)
    public List<Seat> findFlightSeats() {
        return flightService.findAllSeats();
    }

    // Read FlightById
    @RequestMapping(path = "/flight/{flightId}", method = RequestMethod.GET)
    public Flight findByFlightId(@PathVariable int flightId) {
        return flightService.findByFlightId(flightId);
    }

    // Read FlightDetails by flightNumber
    @RequestMapping(path = "/flight/flight-details/{flightNumber}", method = RequestMethod.GET)
    public FlightDetails findByDetailsFlightNumber(@PathVariable String flightNumber) {
        return flightService.findByDetailsFlightNumber(flightNumber);
    }

    // Read Seat by seatId
    @RequestMapping(path = "/flight/seat/{seatId}", method = RequestMethod.GET)
    public Seat findBySeatId(@PathVariable int seatId) {
        return flightService.findBySeatId(seatId);
    }

    // Update
    @RequestMapping(path = "/flight/{flightId}", method = RequestMethod.PUT)
    public void updateFlight(@RequestBody Flight flight, @PathVariable int flightId) {
        flightService.updateFlightById(flight, flightId);
    }

    @RequestMapping(path = "/flight/flight-details/{flightNumber}", method = RequestMethod.PUT)
    public void updateFlightDetails(@RequestBody FlightDetails details, @PathVariable String flightNumber) {
        flightService.updateFlightDetailsByFlightNumber(details, flightNumber);
    }

    @RequestMapping(path = "/flight/seat/{seatId}", method = RequestMethod.PUT)
    public void updateSeat(@RequestBody Seat seat, @PathVariable int seatId) {
        flightService.updateSeatById(seat, seatId);
    }

    // Delete
    @RequestMapping(path = "/flight/{flightId}", method = RequestMethod.DELETE)
    public void removeFlight(@PathVariable int flightId) {
        flightService.removeFlight(flightId);
    }

    @RequestMapping(path = "/flight/flight-details/{flightNumber}", method = RequestMethod.DELETE)
    public void removeFlightDetails(@PathVariable String flightNumber) {
        flightService.removeFlightDetails(flightNumber);
    }

    @RequestMapping(path = "/flight/seat/{seatId}", method = RequestMethod.DELETE)
    public void removeSeat(@PathVariable int seatId) {
        flightService.removeSeat(seatId);
    }

    @RequestMapping(path = "/flight", method = RequestMethod.DELETE)
    public void removeAllFlights() {
        flightService.removeAllFlights();
    }

    @RequestMapping(path = "/flight/flight-details", method = RequestMethod.DELETE)
    public void removeAllFlightDetails() {
        flightService.removeAllFlightDetails();
    }

    @RequestMapping(path = "/flight/seats", method = RequestMethod.DELETE)
    public void removeAllFlightSeats() {
        flightService.removeAllSeats();
    }
}
