package com.group19.flightfinder.Dao;

import com.group19.flightfinder.Entity.Price;
import com.group19.flightfinder.JdbcConnection;
import com.group19.flightfinder.RowMapper.PriceRowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PriceDao {
    private JdbcConnection jdbcConnection;

    public PriceDao() {
        this.jdbcConnection = JdbcConnection.getInstance();
    }

    public List<Price> getAllPrices() throws SQLException {
        List<Price> prices = new ArrayList<>();
        String query = "SELECT * FROM prices";
        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            PriceRowMapper rowMapper = new PriceRowMapper();
            while (rs.next()) {
                prices.add(rowMapper.rowToObject(rs));
            }
        }
        return prices;
    }

    public Price getPriceById(long priceId) throws SQLException {
        String query = "SELECT * FROM prices WHERE priceId = ?";
        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, priceId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    PriceRowMapper rowMapper = new PriceRowMapper();
                    return rowMapper.rowToObject(rs);
                }
            }
        }
        return null;
    }
}
