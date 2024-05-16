package com.group19.flightfinder;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flightId", nullable = false)
    private long flightId;

    @Column(name = "airline", nullable = false)
    private String airline;
    @Column(name = "departure_airport_code", nullable = false)
    private String departureAirportCode;

    @Column(name = "arrival_airport_code", nullable = false)
    private String arrivalAirportCode;

    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;

    @Column(name = "arrival_time", nullable = false)
    private LocalDateTime arrivalTime;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "flightNumber", nullable = false)
    private String flightNumber;

    // Constructors, Getters and Setters

    public Flight() {
    }

    // Assume other constructors as needed

    // Getters

    public String getAirline() {
        return airline;
    }

    public long getFlightId() {
        return flightId;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public Double getPrice() {
        return price;
    }

    public String getFlightNumber(){return flightNumber;}
    // Setters

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setFlightNumber(String flightNumber){this.flightNumber = flightNumber;}

    // Optional: ToString, Equals, and HashCode Methods
}
