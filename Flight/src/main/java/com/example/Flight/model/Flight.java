package com.example.Flight.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="tbl_flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="flightId")
    private int flightId;

    @Column(name = "departTime", columnDefinition = "TIMESTAMP")
    private LocalDateTime departTime;

    @Column(name="seatsAvailable")
    private int seatsAvailable;

    @Column(name="price")
    private double price;

    @Column(name="arrivalTime", columnDefinition = "TIMESTAMP")
    private LocalDateTime arrivalTime;

    @OneToOne
    @JoinColumn(name = "flightNumber")
    private FlightDetails details;

    @OneToMany(mappedBy = "flight")
    List<Seat> seats;

    public Flight(LocalDateTime departTime, int seatsAvailable, double price, LocalDateTime arrivalTime) {
        super();
        this.departTime = departTime;
        this.seatsAvailable = seatsAvailable;
        this.price = price;
        this.arrivalTime = arrivalTime;
    }
}
