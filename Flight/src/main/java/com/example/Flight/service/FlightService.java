package com.example.Flight.service;

import com.example.Flight.model.Flight;
import com.example.Flight.model.FlightDetails;
import com.example.Flight.model.Seat;
import com.example.Flight.repository.FlightDetailsRepository;
import com.example.Flight.repository.FlightRepository;
import com.example.Flight.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightDetailsRepository flightDetailsRepo;

    @Autowired
    FlightRepository flightRepo;

    @Autowired
    SeatRepository seatRepo;

    // Create
    public void addFlight(Flight flight) {
        flightRepo.save(flight);
    }

    public void addFlightDetails(FlightDetails flightDetails) {
        flightDetailsRepo.save(flightDetails);
    }

    public void addSeat(Seat seat) {
        seatRepo.save(seat);
    }

    // Read
    public Flight findByFlightId(int flightId) {
        return flightRepo.findByFlightId(flightId);
    }

    public FlightDetails findByDetailsFlightNumber(String flightNumber) {
        return flightDetailsRepo.findByFlightNumber(flightNumber);
    }

    public Seat findBySeatId(int seatId) {
        return seatRepo.findBySeatId(seatId);
    }

    public List<Flight> findAllFlights() {
        return flightRepo.findAll();
    }

    public List<FlightDetails> findAllFlightDetails() {
        return flightDetailsRepo.findAll();
    }

    public List<Seat> findAllSeats() {
        return seatRepo.findAll();
    }

    // Update
    public void updateFlightDetailsByFlightNumber(FlightDetails details, String flightNumber) {
        FlightDetails detailsToUpdate = findByDetailsFlightNumber(flightNumber);
        detailsToUpdate.setArriveCityId(details.getArriveCityId());
        detailsToUpdate.setDepartCityId(details.getDepartCityId());
        flightDetailsRepo.save(detailsToUpdate);
    }

    public void updateFlightById(Flight flight, int flightId) {
        Flight flightToUpdate = findByFlightId(flightId);
        flightToUpdate.setSeatsAvailable(flight.getSeatsAvailable());
        flightToUpdate.setPrice(flight.getPrice());
        flightToUpdate.setArrivalTime(flight.getArrivalTime());
        flightToUpdate.setDepartTime(flight.getDepartTime());
        flightRepo.save(flightToUpdate);
    }

    public void updateSeatById(Seat seat, int seatId) {
        Seat seatToUpdate = findBySeatId(seatId);
        seatToUpdate.setSeatLocation(seat.getSeatLocation());
        seatToUpdate.setSeatClass(seat.getSeatClass());
        seatRepo.save(seatToUpdate);
    }

    // Delete
    public void removeFlight(int flightId) {
        Flight flight = flightRepo.findByFlightId(flightId);
        flightRepo.delete(flight);
    }

    public void removeSeat(int seatId) {
        Seat seat = seatRepo.findBySeatId(seatId);
        seatRepo.delete(seat);
    }

    public void removeFlightDetails(String flightNumber) {
        FlightDetails details = flightDetailsRepo.findByFlightNumber(flightNumber);
        flightDetailsRepo.delete(details);
    }

    public void removeAllFlights() {
        flightRepo.deleteAll();
    }

    public void removeAllFlightDetails() {
        flightDetailsRepo.deleteAll();
    }

    public void removeAllSeats() {
        seatRepo.deleteAll();
    }

    // Functions for testing
    public boolean flightExists() {
        return flightRepo.count() == 0 ? false : true;
    }

    public boolean seatExists() {
        return seatRepo.count() == 0 ? false : true;
    }
    public boolean flightDetailsExists() {
        return flightDetailsRepo.count() == 0 ? false : true;
    }
}
