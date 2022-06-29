package com.smoothstack.utopiaairlines.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.utopiaairlines.models.Booking;
import com.smoothstack.utopiaairlines.models.Traveler;
import com.smoothstack.utopiaairlines.repository.BookingRepository;
import com.smoothstack.utopiaairlines.repository.TravelerRepository;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository bookingRepo;
	
	@Autowired
	TravelerRepository travelerRepo;
	
	//Create
	public void addBooking(Booking booking) {
		bookingRepo.save(booking);
	}
	
	public void addTraveler(Traveler traveler) {
		travelerRepo.save(traveler);
	}
	
	//Read
	public Booking getBooking(int id) {
		return bookingRepo.findByBookingId(id);
	}
	
	public List<Booking> getAllBookings() {
		return bookingRepo.findAll();
	}
	
	public Traveler getTraveler(int id) {
		return travelerRepo.findByTravelerId(id);
	}
	public List<Traveler> getAllTravelers() {
		return travelerRepo.findAll();
	}
	
	//Update
	public void updateBooking(Booking booking, int bookingId) {
		Booking targetBooking = getBooking(bookingId);
		targetBooking.setIsActive(booking.getIsActive());
		targetBooking.setStripeId(booking.getStripeId());
		targetBooking.setBookerId(booking.getBookerId());
		targetBooking.setSeatId(booking.getSeatId());
		bookingRepo.save(targetBooking);
	}
	
	public void updateTraveler(Traveler traveler, int travelerId) {
		Traveler targetTraveler = getTraveler(travelerId);
		targetTraveler.setName(traveler.getName());
		targetTraveler.setAddress(traveler.getAddress());
		targetTraveler.setPhone(traveler.getPhone());
		targetTraveler.setEmail(traveler.getEmail());
		targetTraveler.setDob(traveler.getDob());
	}
	
	//Delete
	public void removeBooking(int bookingId) {
		Booking targetBooking = getBooking(bookingId);
		bookingRepo.delete(targetBooking);
	}
	public void removeAllBookings() {
		bookingRepo.deleteAll();
	}
	
	public void removeTraveler(int travelerId) {
		Traveler targetTraveler = getTraveler(travelerId);
		travelerRepo.delete(targetTraveler);
	}
	public void removeAllTravelers() {
		travelerRepo.deleteAll();
	}
	//Testing
	public boolean bookingExists() {
		return !(bookingRepo.count() == 0);
	}
	
	public boolean travelerExists() {
		return !(travelerRepo.count() == 0);
	}
}
