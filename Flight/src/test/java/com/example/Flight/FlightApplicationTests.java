package com.example.Flight;

import com.example.Flight.model.Flight;
import com.example.Flight.model.FlightDetails;
import com.example.Flight.model.Seat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.Flight.service.FlightService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class FlightApplicationTests {

	@Autowired
	FlightService service;

	@BeforeEach
	void setUp() {
		if (service.seatExists()) {
			service.removeAllSeats();
		}
		if (service.flightExists()) {
			service.removeAllFlights();
		}
		if (service.flightDetailsExists()) {
			service.removeAllFlightDetails();
		}
	}

	@Test
	void contextLoads() {
	}

//	@Test
//	void noFlightsAddSeat() {
//		service.removeAllFlights();
//		service.addSeat(new Seat("2A", "First Class"));
//	}

	// Create tests
	@Test
	void addFlight() {
		Flight flight = new Flight(LocalDateTime.now(), 5, 129.23, LocalDateTime.now());
		FlightDetails details = new FlightDetails("REM4", "DEN", "LAX");
		service.addFlightDetails(details);
		flight.setDetails(details);
		service.addFlight(flight);
		Assertions.assertNotNull(flight.getFlightId());
	}

	@Test
	void addFlightDetails() {
		FlightDetails details = new FlightDetails("XYZA", "DEN", "LAX");
		service.addFlightDetails(details);
		Assertions.assertEquals(service.findByDetailsFlightNumber("XYZA").getFlightNumber(), details.getFlightNumber());
	}

	@Test
	void addSeat() {
		FlightDetails details = new FlightDetails("REM4", "DEN", "LAX");
		Seat seat = new Seat("2A", "First Class");
		Flight flight = new Flight(LocalDateTime.now(), 5, 129.23, LocalDateTime.now());
		service.addFlightDetails(details);
		flight.setDetails(details);
		service.addFlight(flight);
		seat.setFlight(flight);
		service.addSeat(seat);
		Assertions.assertNotNull(seat.getSeatId());
	}

	// Read tests
	@Test
	void findByFlightId() {
		Flight flight1 = new Flight(LocalDateTime.now(), 5, 129.23, LocalDateTime.now());
		FlightDetails details1 = new FlightDetails("REM4", "DEN", "LAX");
		service.addFlightDetails(details1);
		flight1.setDetails(details1);
		service.addFlight(flight1);
		Flight flight2 = new Flight(LocalDateTime.now(), 5, 129.23, LocalDateTime.now());
		FlightDetails details2 = new FlightDetails("AVSC", "DEN", "LAX");
		service.addFlightDetails(details2);
		flight2.setDetails(details2);
		service.addFlight(flight2);
		Flight flight3 = new Flight(LocalDateTime.now(), 5, 129.23, LocalDateTime.now());
		FlightDetails details3 = new FlightDetails("3DER", "DEN", "LAX");
		service.addFlightDetails(details3);
		flight3.setDetails(details3);
		service.addFlight(flight3);
		Assertions.assertEquals(flight2.getFlightId(), service.findByFlightId(flight2.getFlightId()).getFlightId());
	}

	@Test
	void findByDetailsFlightNumber() {
		FlightDetails details1 = new FlightDetails("REM4", "DEN", "LAX");
		service.addFlightDetails(details1);
		FlightDetails details2 = new FlightDetails("AVSC", "DEN", "LAX");
		service.addFlightDetails(details2);
		FlightDetails details3 = new FlightDetails("3DER", "DEN", "LAX");
		service.addFlightDetails(details3);
		FlightDetails details = service.findByDetailsFlightNumber("AVSC");
		Assertions.assertEquals(details2.getFlightNumber(), details.getFlightNumber());
	}

	@Test
	void findBySeatId() {
		Flight flight1 = new Flight(LocalDateTime.now(), 5, 129.23, LocalDateTime.now());
		FlightDetails details1 = new FlightDetails("REM4", "DEN", "LAX");
		Seat seat1 = new Seat("2A", "First Class");
		service.addFlightDetails(details1);
		flight1.setDetails(details1);
		service.addFlight(flight1);
		seat1.setFlight(flight1);
		service.addSeat(seat1);
		Flight flight2 = new Flight(LocalDateTime.now(), 5, 129.23, LocalDateTime.now());
		FlightDetails details2 = new FlightDetails("AVSC", "DEN", "LAX");
		Seat seat2 = new Seat("2A", "First Class");
		service.addFlightDetails(details2);
		flight2.setDetails(details2);
		service.addFlight(flight2);
		seat2.setFlight(flight2);
		service.addSeat(seat2);
		Flight flight3 = new Flight(LocalDateTime.now(), 5, 129.23, LocalDateTime.now());
		FlightDetails details3 = new FlightDetails("3DER", "DEN", "LAX");
		Seat seat3 = new Seat("2A", "First Class");
		service.addFlightDetails(details3);
		flight3.setDetails(details3);
		service.addFlight(flight3);
		seat3.setFlight(flight3);
		service.addSeat(seat3);
		Assertions.assertEquals(seat2.getSeatId(), service.findBySeatId(seat2.getSeatId()).getSeatId());
	}

	@Test
	void findAllFlights() {
		Flight flight1 = new Flight(LocalDateTime.now(), 5, 129.23, LocalDateTime.now());
		FlightDetails details1 = new FlightDetails("REM4", "DEN", "LAX");
		service.addFlightDetails(details1);
		flight1.setDetails(details1);
		service.addFlight(flight1);
		Flight flight2 = new Flight(LocalDateTime.now(), 5, 129.23, LocalDateTime.now());
		FlightDetails details2 = new FlightDetails("AVSC", "DEN", "LAX");
		service.addFlightDetails(details2);
		flight2.setDetails(details2);
		service.addFlight(flight2);
		Flight flight3 = new Flight(LocalDateTime.now(), 5, 129.23, LocalDateTime.now());
		FlightDetails details3 = new FlightDetails("3DER", "DEN", "LAX");
		service.addFlightDetails(details3);
		flight3.setDetails(details3);
		service.addFlight(flight3);
		List<Flight> flights = service.findAllFlights();
		List<Integer> actualId = new ArrayList<>();
		for (Flight flight : flights) {
			actualId.add(flight.getFlightId());
		}
		List<Integer> expectedId = new ArrayList<>();
		expectedId.add(flight1.getFlightId());
		expectedId.add(flight2.getFlightId());
		expectedId.add(flight3.getFlightId());

		Assertions.assertEquals(expectedId, actualId);
	}

	@Test
	void findAllFlightDetails() {
		FlightDetails details1 = new FlightDetails("REM4", "DEN", "LAX");
		service.addFlightDetails(details1);
		FlightDetails details2 = new FlightDetails("AVSC", "DEN", "LAX");
		service.addFlightDetails(details2);
		FlightDetails details3 = new FlightDetails("3DER", "DEN", "LAX");
		service.addFlightDetails(details3);
		List<FlightDetails> details = service.findAllFlightDetails();
		List<String> actualId = new ArrayList<>();
		for (FlightDetails detail : details) {
			actualId.add(detail.getFlightNumber());
		}
		List<String> expectedId = new ArrayList<>();
		expectedId.add(details1.getFlightNumber());
		expectedId.add(details2.getFlightNumber());
		expectedId.add(details3.getFlightNumber());

		Assertions.assertEquals(expectedId, actualId);
	}

	@Test
	void findAllSeats() {

	}
}
