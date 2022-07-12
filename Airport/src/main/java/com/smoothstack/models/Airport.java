package com.smoothstack.models;

import lombok.Data;

@Data
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
}
