package com.smoothstack.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportController {

    @RequestMapping("/")
    String hello() {
        return "Hello World!";
    }

}
