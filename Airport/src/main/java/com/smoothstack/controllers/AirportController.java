package com.smoothstack.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.smoothstack.services.AirportService;
import com.smoothstack.models.Airport;

@RestController
public class AirportController {

    @RequestMapping("/airports/{airportId}")
    public String getAirportById(@PathVariable Integer airportId) {
        return AirportService.getAirportById("utopia.tbl_airport", airportId).toString();
    }

    @RequestMapping
    public void postAirport(@RequestBody Airport airport) {
        AirportService.createAirport("utopia.tbl_airport", airport);
    }

    @RequestMapping("/")
    public String mainRoute() {
        return "Airport Microservice";
    }
}
