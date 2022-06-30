package com.smoothstack.models;

public class Airport {
    private int airportId;
    private String city;
    private String name;
    private String iataIdent;

    public Airport() {

    }
    public Airport(int _airportId, String _city, String _name, String _iataIdent) {
        airportId = _airportId;
        city = _city;
        name = _name;
        iataIdent = _iataIdent;
        
    }

    public void setAirportId(int _id) {
        airportId = _id;
    }

    public int getAirportId() {
        return airportId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String _city) {
        city = _city;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        name = _name;
    }

    public String getIataIdent() {
        return iataIdent;
    }

    public void setIataIdent(String _iataIdent) {
        iataIdent = _iataIdent;
    }


    @Override
    public String toString() {
        //Need to convert this to JSON
        return "";
    }
}
