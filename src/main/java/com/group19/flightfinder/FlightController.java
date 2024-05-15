package com.group19.flightfinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    private com.group19.flightfinder.FlightService service;

    @Autowired
    private FlightService flightService;
    @GetMapping
    public List<Flight> getAllFlights() {
        return service.findAllFlights();
    }

    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return service.saveFlight(flight);
    }

    @PutMapping("/flight/{flightId}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long flightId,@RequestBody Flight flightDetails){
        Flight flight = flightService.findFlightById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found with id " + flightId));
        flight.setAirline(flightDetails.getAirline());
        flight.setFlightId(flightDetails.getFlightId());
        flight.setDepartureAirportCode(flightDetails.getDepartureAirportCode());
        flight.setArrivalAirportCode(flightDetails.getArrivalAirportCode());
        flight.setDepartureTime(flightDetails.getDepartureTime());
        flight.setArrivalTime(flightDetails.getArrivalTime());
        flight.setPrice(flightDetails.getPrice());
        flight.setFlightNumber(flightDetails.getFlightNumber());

        final Flight updatetFlight = flightService.saveFlight(flight);
        return ResponseEntity.ok(updatetFlight);

    }
    public HashMap<String, Boolean> deleteFlight(@PathVariable (value = "id")Long flightId) throws ResourceNotFoundException{
        Flight flight = flightService.findFlightById(flightId).orElseThrow(() ->new ResourceNotFoundException("Flight not found for this id :: " + flightId));
        flightService.deleteFlight(flight);
        HashMap<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}

