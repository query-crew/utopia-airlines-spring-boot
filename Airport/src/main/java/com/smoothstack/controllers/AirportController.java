package com.smoothstack.controllers;

import org.springframework.web.bind.annotation.*;
import com.smoothstack.services.AirportService;
import com.smoothstack.models.Airport;

@RestController
public class AirportController {

    @RequestMapping(path = "/airports/{airportId}", method = RequestMethod.GET)
    public String getAirportById(@PathVariable Integer airportId) {
        return AirportService.getAirportById("utopia.tbl_airport", airportId).toString();
    }

    @RequestMapping(path = "/airports", method = RequestMethod.POST)
    public void postAirport(@RequestBody Airport airport) {
        AirportService.createAirport("utopia.tbl_airport", airport);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String mainRoute() {
        return "Airport Microservice";
    }
}
