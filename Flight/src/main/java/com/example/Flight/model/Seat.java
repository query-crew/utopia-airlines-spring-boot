package com.example.Flight.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="tbl_seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatId;

    @Column(name = "seatLocation")
    private String seatLocation;

    @Column(name="seatClass")
    private String seatClass;

    @ManyToOne
    @JoinColumn(name="flightId")
    Flight flight;

    public Seat(String seatLocation, String seatClass) {
        super();
        this.seatLocation = seatLocation;
        this.seatClass = seatClass;
    }
}