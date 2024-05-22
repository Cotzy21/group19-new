package com.group19.flightfinder;

import com.group19.flightfinder.Entity.Flight;

import java.sql.SQLException;
import java.util.List;

public class FlightService {
    private final FlightDao flightDao;

    public FlightService() {
        this.flightDao = new FlightDao();
    }

    public List<Flight> getAllFlights() throws SQLException {
        return flightDao.getAllFlights();
    }

    public Flight getFlightById(long flightId) throws SQLException {
        return flightDao.getFlightById(flightId);
    }

    // Add more methods as needed (create, update, delete)
}
