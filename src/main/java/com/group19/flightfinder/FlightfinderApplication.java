package com.group19.flightfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication

@EntityScan(basePackages = {"com.group19.flightfinder"})
public class FlightfinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightfinderApplication.class, args);
	}
}
