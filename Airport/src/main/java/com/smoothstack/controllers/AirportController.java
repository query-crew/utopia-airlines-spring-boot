package com.smoothstack.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.smoothstack.services.AirportService;

@RestController
public class AirportController {

    @RequestMapping("/airports/{airportId}")
    public String getAirportById(@PathVariable Integer airportId) {
        return AirportService.getAirportById(airportId).toString();
        //return airportId.toString();
    }

    @RequestMapping("/")
    public String mainRoute() {
        return "Airport Microservice";
    }
}
