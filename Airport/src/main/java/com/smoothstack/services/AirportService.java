package com.smoothstack.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.models.Airport;

public class AirportService {

    public static void createAirportTable(String tableName) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia_schema", "root", "root");
            PreparedStatement stmt = conn.prepareStatement("CREATE TABLE " + tableName + "(airportId INT, city VARCHAR(100), name VARCHAR(100), iataIdent VARCHAR(4), PRIMARY KEY(airportId));");
            
            if(stmt.execute()) {
                System.out.println("Airport Table Created: " + tableName);
            }
        }
        catch(SQLException _ex) {
            System.out.println(_ex.getMessage());
        }
    }

    public static void dropAirportTable(String tableName) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia_schema", "root", "root");
            PreparedStatement stmt = conn.prepareStatement("DROP TABLE " + tableName);
            if(stmt.execute()) {
                System.out.println("Airport Table Dropped: " + tableName);
            }
        }
        catch(SQLException _ex) {
            System.out.println(_ex.getMessage());
        }
    }

    public static Airport getAirportById(int _airportId) {
        try {
            Airport airport;
            //Using root password is a really bad idea, but it took me an hour to reset it, so there.
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia_schema", "root", "root");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM airports WHERE flightId = " + _airportId);
            ResultSet results = stmt.executeQuery();
            if(results.next()) {
                airport = new Airport(results.getInt(0), results.getString(1), results.getString(2), results.getString(3));
                conn.close();
                return airport;
            }
            else {
                //Return null if the airportId is not found
                airport = null;
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

    public static void createAirport(String tableName, Airport _airport) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia_schema", "root", "root");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO " + tableName + "VALUES(" + 
                _airport.getAirportId() + ", " +
                _airport.getCity() + ", " + 
                _airport.getName() + ", " +
                _airport.getIataIdent()
            );

            if(stmt.execute()) {
                System.out.println("Created airport: " + _airport.toString());
            }
            else {
                System.out.println("Failed to create airport");
            }
        }
        catch(SQLException _ex) {
            System.out.println(_ex.getMessage());
        }
    }

    public static void updateAirport(String tableName, int airportId, Airport _airport) {

    }

    public static void deleteAirport(String tableName, int airportId) {

    }

    public static List<Airport> getAllAirports() {
        List<Airport> airports = new ArrayList<Airport>();
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia_schema", "root", "root");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM airports");
            ResultSet results = stmt.executeQuery();
            if(results.next()) {
                Airport airport = new Airport(results.getInt(0), results.getString(1), results.getString(2), results.getString(3));
                airports.add(airport);
            }

            return airports;
        }
        catch(SQLException _ex) {
            System.out.println(_ex.getMessage());
            return null;
        }
    }
}
