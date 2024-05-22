package com.group19.flightfinder.RowMapper;

import com.group19.flightfinder.Entity.Flight;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class FlightRowMapper implements RowMapper<Flight> {
    @Override
    public Flight rowToObject(ResultSet rs) {
        try {
            long flightId = rs.getLong("flightId");
            String airline = rs.getString("airline");
            String departureAirportCode = rs.getString("departureAirportCode");
            String arrivalAirportCode = rs.getString("arrivalAirportCode");
            Timestamp departureTimestamp = rs.getTimestamp("departureTime");
            LocalDateTime departureTime = departureTimestamp != null ? departureTimestamp.toLocalDateTime() : null;
            Timestamp arrivalTimestamp = rs.getTimestamp("arrivalTime");
            LocalDateTime arrivalTime = arrivalTimestamp != null ? arrivalTimestamp.toLocalDateTime() : null;
            Double price = rs.getDouble("price");
            String flightNumber = rs.getString("flightNumber");

            return new Flight(flightId, airline, departureAirportCode, arrivalAirportCode, departureTime, arrivalTime, price, flightNumber);
        } catch (SQLException e) {
            System.err.println("Error while converting SQL row to Flight: " + e.getMessage());
            return null;
        }
    }
}
