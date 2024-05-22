package com.group19.flightfinder;

import com.group19.flightfinder.Entity.Flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    // JpaRepository already provides methods like findAll, save, findById, deleteById, etc.
    // You can add custom query methods if needed.
}

