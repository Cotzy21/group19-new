package com.group19.flightfinder.Dao;
import com.group19.flightfinder.Entity.Flight;
import com.group19.flightfinder.JdbcConnection;
import com.group19.flightfinder.RowMapper.FlightRowMapper;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDao {
    private JdbcConnection jdbcConnection;

    public FlightDao() {
        this.jdbcConnection = JdbcConnection.getInstance();
    }

    public List<Flight> getAllFlights() throws SQLException {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT * FROM flights";
        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            FlightRowMapper rowMapper = new FlightRowMapper();
            while (rs.next()) {
                flights.add(rowMapper.rowToObject(rs));
            }
        }
        return flights;
    }

    public Flight getFlightById(long flightId) throws SQLException {
        String query = "SELECT * FROM flights WHERE flightId = ?";
        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, flightId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    FlightRowMapper rowMapper = new FlightRowMapper();
                    return rowMapper.rowToObject(rs);
                }
            }
        }
        return null;
    }

    // Add more methods as needed (create, update, delete)
}
