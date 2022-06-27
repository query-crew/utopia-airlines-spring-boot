package com.smoothstack.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.smoothstack.models.Airport;

public class AirportService {
    public static Airport getAirportById(int _airportId) {
        try {
            Airport airport;
            //Using root password is a really bad idea, but it took me an hour to reset it, so there.
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia_schema", "root", "root");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM airports WHERE flightId = " + _airportId);
            ResultSet results = stmt.executeQuery();
            if(results.next()) {
                airport = new Airport();
                conn.close();
                return airport;
            }
            else {
                //Yes, this is bad. It's also late, I'll work on this later.
                airport = new Airport();
                conn.close();
                return airport;
            }
            
        }
        catch(SQLException _ex) {
            //Probably change this to use logging instead
            System.out.println(_ex.getMessage());
            return null;
        }
    }

    public static List<Airport> getAllAirports() {
        List<Airport> airports = new ArrayList();
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia_schema", "root", "root");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM airports");
            ResultSet results = stmt.executeQuery();
            if(results.next()) {
                //Actually implement this part later
                
            }
            else {

            }
        }
        catch(SQLException _ex) {
            System.out.println(_ex.getMessage());
            return null;
        }

        return airports;
    }
}
