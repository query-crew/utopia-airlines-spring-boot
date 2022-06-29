package com.smoothstack;

import com.smoothstack.models.Airport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.smoothstack.services.AirportService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration

public class AirportControllerTest {

    private String airportTableName = "test_airport_table";
    private Airport testAirport = new Airport(0, new Timestamp(0), 10, 29.99f, new Timestamp(1200), "A111");
    private Airport updatedAirport = new Airport(0, new Timestamp(0), 9, 39.99f, new Timestamp(1200), "A111");


    @Before
    void setUp() {
        AirportService.createAirportTable(airportTableName);
    }

    @Test
    void createAirportTest() {
        try {
            AirportService.createAirport(airportTableName, testAirport);
        }
        catch(Exception _ex) {
            fail();
        }
    }

    @Test
    void readAirportTest() {
        try {
            Airport readAirport = AirportService.getAirportById(0);
            if(readAirport == null) {
                fail();
            }
            else {
                assertEquals(readAirport, testAirport);
            }
        }
        catch(Exception _ex) {
            fail();
        }
    }

    @Test
    void updateAirportTest() {
        try {
            AirportService.updateAirport(airportTableName, 0, updatedAirport);

            Airport retrieveNewAirportInfo = AirportService.getAirportById(0);
            if(retrieveNewAirportInfo == null) {
                fail();
            }
            else {
                assertEquals(updatedAirport, retrieveNewAirportInfo);
            }
        }
        catch(Exception _ex) {
            fail();
        }
    }

    @Test
    void deleteAirportTest() {
        try {
            AirportService.deleteAirport(airportTableName, 0);

            Airport retrieveAirport = AirportService.getAirportById(0);
            if(retrieveAirport != null) {
                fail();
            }
            else {
                assertEquals(true, true);
            }
        }
        catch(Exception _ex) {
            fail();
        }
    }

    @After
    void cleanUp() {
        AirportService.dropAirportTable(airportTableName);
    }
}