package com.example.Flight.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="tbl_flight_details")
public class FlightDetails {
    @Id
    @Column(name="flightNumber")
    private String flightNumber;

    @Column(name = "departCityId")
    private String departCityId;

    @Column(name="arriveCityId")
    private String arriveCityId;

    @JsonIgnore
    @OneToOne(mappedBy = "details")
    private Flight flight;

    public FlightDetails(String flightNumber, String departCityId, String arriveCityId) {
        super();
        this.flightNumber = flightNumber;
        this.departCityId = departCityId;
        this.arriveCityId = arriveCityId;
    }
}