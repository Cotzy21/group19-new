package com.group19.flightfinder;


import com.group19.flightfinder.Flight;
import com.group19.flightfinder.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Optional<Flight> findFlightById(long flightId) {
        return flightRepository.findById(flightId);
    }
    public void deleteFlight(Flight flight) {
        flightRepository.delete(flight);
    }

}