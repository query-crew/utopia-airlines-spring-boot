package com.smoothstack.orches0617.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrchController {
	
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/data/airports")
	public String airportData() {
		return restTemplate.getForEntity("http://airport-service/data/airport", String.class).getBody();
	}
	

	@RequestMapping("/data/bookings")
	public String bookingData() {
		return restTemplate.getForEntity("http://bookings-service/data/bookings", String.class).getBody();
	}

	@RequestMapping("/data/flights")
	public String flightData() {
		return restTemplate.getForEntity("http://flights-service/data/flights", String.class).getBody();
	}

	@RequestMapping("/data/users")
	public String userData() {
		return restTemplate.getForEntity("http://users-service/data/users", String.class).getBody();
	}
}
