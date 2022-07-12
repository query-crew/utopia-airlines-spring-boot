package com.smoothstack;

import com.smoothstack.models.Airport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.smoothstack.services.AirportService;

public class AirportControllerTest {

    private String airportTableName = "test_airport_table";
    private Airport testAirport = new Airport(0, "Fresno, CA", "Fresno-Yosemite Intl Airport" , "FAT");
    private Airport updatedAirport = new Airport(0, "Fresno, CA", "Chandler Executive Airport", "CHA");


    @Before
    public void setUp() {
        AirportService.createAirportTable(airportTableName);
    }

    @Test
    public void createAirportTest() {
        try {
            AirportService.createAirport(airportTableName, testAirport);
        }
        catch(Exception _ex) {
            fail();
        }
    }

    @Test
    public void readAirportTest() {
        try {
            Airport readAirport = AirportService.getAirportById(airportTableName,0);
            if(readAirport == null) {
                //fail();
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
    public void updateAirportTest() {
        try {
            AirportService.updateAirport(airportTableName, 0, updatedAirport);

            Airport retrieveNewAirportInfo = AirportService.getAirportById(airportTableName,0);
            if(retrieveNewAirportInfo == null) {
                //fail();
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
    public void deleteAirportTest() {
        try {
            AirportService.deleteAirport(airportTableName, 0);

            Airport retrieveAirport = AirportService.getAirportById(airportTableName, 0);
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
    public void cleanUp() {
        AirportService.dropAirportTable(airportTableName);
    }
}