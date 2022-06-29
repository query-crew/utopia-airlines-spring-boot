package com.smoothstack.utopiaairlines.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.smoothstack.utopiaairlines.models.Traveler;

public interface TravelerRepository extends CrudRepository<Traveler, Integer> {
	List<Traveler> findAll();
	Traveler findByTravelerId(int travelerId);
}
