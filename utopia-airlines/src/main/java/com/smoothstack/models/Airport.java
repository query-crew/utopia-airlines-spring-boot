package com.smoothstack.models;

import java.sql.Timestamp;

public class Airport {
    private int flightId;
    private Timestamp departTime;
    private int seatsAvailable;
    private float price;
    private Timestamp arrivalTime;
    private String flightNumber;

    public Airport() {

    }
    public Airport(int _flightId, Timestamp _departTime, int _seatsAvailable, float _price, Timestamp _arrivalTime, String _flightNumber) {
        flightId = _flightId;
        departTime = _departTime;
        seatsAvailable = _seatsAvailable;
        price = _price;
        arrivalTime = _arrivalTime;
        flightNumber = _flightNumber;
    }

    public void setFlightId(int _id) {
        flightId = _id;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setDepartTime(Timestamp _departTime) {
        departTime = _departTime;
    }

    public Timestamp getDepartTime() {
        return departTime;
    }

    public void setSeatsAvailable(int _seatsAvailable) {
        seatsAvailable = _seatsAvailable;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setPrice(float _price) {
        price = _price;
    }

    public float getPrice() {
        return price;
    }

    public void setArrivalTime(Timestamp _arrivalTime) {
        arrivalTime = _arrivalTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setFlightNumber(String _flightNumber) {
        flightNumber = _flightNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    @Override
    public String toString() {
        //Need to convert this to JSON
        return "";
    }
}
