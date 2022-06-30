package com.smoothstack.utopiaairlines;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import org.junit.Assert.*;
import com.smoothstack.utopiaairlines.controllers.BookingsController;
import com.smoothstack.utopiaairlines.models.Booking;
import com.smoothstack.utopiaairlines.models.Traveler;
import com.smoothstack.utopiaairlines.services.BookingService;

@SpringBootTest
class UtopiaAirlinesApplicationTests {
	
	@Autowired
	private BookingsController controller;
	@Autowired
	private BookingService service;
	
	@BeforeEach
	void setUp() {
		if (service.bookingExists()) {
			service.removeAllBookings();
		}
		if (service.travelerExists()) {
			service.removeAllTravelers();
		}
	}
	@Test
	public void contextLoads() {
		Assertions.assertNotNull(controller);
	}
	
	@Test
	public void addBooking() {
		Booking b = new Booking(1, "STRIPE", 1, 4);
		service.addBooking(b);
		Assertions.assertNotNull(b.getBookingId());
	}
	
	@Test
	public void addTraveler() {
		Traveler t = new Traveler("Billy Bob", "123 Road", "123456789", "email@email.com", LocalDateTime.of(2020,  1, 14, 10, 30));
		service.addTraveler(t);
		Assertions.assertNotNull(t.getTravelerId());
	}
	
	@Test
	public void findBooking() {
		Booking b = new Booking(1, "STRIPE2", 1, 4);
		service.addBooking(b);
		int bId = b.getBookingId();
		Booking b2 = service.getBooking(bId);
		Assertions.assertEquals(b2.toString(), b.toString());

	}
	
	@Test
	public void findTraveler() {
		Traveler t = new Traveler("Billy Milly", "123 Road", "123456789", "email@email.com", LocalDateTime.of(2020,  1, 14, 10, 30));
		service.addTraveler(t);
		int tId = t.getTravelerId();
		Traveler t2 = service.getTraveler(tId);
		Assertions.assertEquals(t.toString(), t2.toString());
	}
}
