package com.group19.flightfinder.Service;

import com.group19.flightfinder.Entity.Flight;
import com.group19.flightfinder.ResourceNotFoundException;
import com.group19.flightfinder.Repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with id: " + id));
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(long id, Flight flightDetails) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with id: " + id));

        flight.setAirline(flightDetails.getAirline());
        flight.setDepartureAirportCode(flightDetails.getDepartureAirportCode());
        flight.setArrivalAirportCode(flightDetails.getArrivalAirportCode());
        flight.setDepartureTime(flightDetails.getDepartureTime());
        flight.setArrivalTime(flightDetails.getArrivalTime());
        flight.setPrice(flightDetails.getPrice());
        flight.setFlightNumber(flightDetails.getFlightNumber());

        return flightRepository.save(flight);
    }

    public boolean deleteFlight(long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with id: " + id));

        flightRepository.delete(flight);
        return true;
    }
}
