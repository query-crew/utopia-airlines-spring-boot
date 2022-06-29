package com.smoothstack.utopiaairlines.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.utopiaairlines.models.Booking;
import com.smoothstack.utopiaairlines.models.Traveler;
import com.smoothstack.utopiaairlines.services.BookingService;

@RestController
public class BookingsController {
	@Autowired
	BookingService bookingService;
	
	//Create
	@RequestMapping(path = "/booking", method = RequestMethod.POST)
	public void addNewBooking(@RequestBody Booking booking) {
		bookingService.addBooking(booking);
	}
	
	@RequestMapping(path = "/booking/traveler", method = RequestMethod.POST)
	public void addNewTraveler(@RequestBody Traveler traveler) {
		bookingService.addTraveler(traveler);
	}
	
	//Read
    @RequestMapping(path = "/booking", method = RequestMethod.GET)
    public List<Booking> getBookings() {
        return bookingService.getAllBookings();
    }
    
    @RequestMapping(path = "/booking/{bookingId}", method = RequestMethod.GET)
    public Booking findByBookingId(@PathVariable int bookingId) {
        return bookingService.getBooking(bookingId);
    }

    @RequestMapping(path = "/booking/traveler", method = RequestMethod.GET)
    public List<Traveler> getTravelers() {
        return bookingService.getAllTravelers();
    }
    
    @RequestMapping(path = "/booking/traveler/{travelerId}", method = RequestMethod.GET)
    public Traveler findByTravelerId(@PathVariable int travelerId) {
        return bookingService.getTraveler(travelerId);
    }
    
    //Update
    @RequestMapping(path = "/booking/{bookingId}", method = RequestMethod.PUT)
    public void updateBooking(@RequestBody Booking booking, @PathVariable int bookingId) {
        bookingService.updateBooking(booking, bookingId);
    }
    
    @RequestMapping(path = "/booking/traveler/{bookingId}", method = RequestMethod.PUT)
    public void updateTraveler(@RequestBody Traveler traveler, @PathVariable int travelerId) {
        bookingService.updateTraveler(traveler, travelerId);
    }
    
    //Delete
    @RequestMapping(path = "/booking", method = RequestMethod.PUT)
    public void removeAllBookings(@RequestBody Booking booking, @PathVariable int bookingId) {
        bookingService.removeAllBookings();
    }    
    @RequestMapping(path = "/booking/{bookingId}", method = RequestMethod.DELETE)
    public void removeBooking(@PathVariable int bookingId) {
        bookingService.removeBooking(bookingId);
    }
    
    @RequestMapping(path = "/booking/traveler", method = RequestMethod.DELETE)
    public void removeAllTravelers(@PathVariable int travelerId) {
        bookingService.removeTraveler(travelerId);
    }
    @RequestMapping(path = "/booking/traveler/{travelerId}", method = RequestMethod.DELETE)
    public void removeTraveler(@PathVariable int travelerId) {
        bookingService.removeTraveler(travelerId);
    }
}
