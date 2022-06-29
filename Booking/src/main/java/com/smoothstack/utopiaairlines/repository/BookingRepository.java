package com.smoothstack.utopiaairlines.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.smoothstack.utopiaairlines.models.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer>{
	List<Booking> findAll();
	Booking findByBookingId(int id);
}
