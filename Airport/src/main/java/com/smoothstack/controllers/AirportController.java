package com.smoothstack.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.smoothstack.services.AirportService;

@RestController
public class AirportController {

    @RequestMapping("/airports/{airportId}")
    public String getAirportById(int _airportId) {
        return AirportService.getAirportById(_airportId).toString();
    }
}
