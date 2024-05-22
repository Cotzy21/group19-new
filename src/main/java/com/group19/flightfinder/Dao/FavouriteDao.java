package com.group19.flightfinder.Dao;

import com.group19.flightfinder.Entity.Favourite;
import com.group19.flightfinder.JdbcConnection;
import com.group19.flightfinder.RowMapper.FavouriteRowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavouriteDao {
    private JdbcConnection jdbcConnection;

    public FavouriteDao() {
        this.jdbcConnection = JdbcConnection.getInstance();
    }

    public List<Favourite> getAllFavourites() throws SQLException {
        List<Favourite> favourites = new ArrayList<>();
        String query = "SELECT * FROM favourites";
        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            FavouriteRowMapper rowMapper = new FavouriteRowMapper();
            while (rs.next()) {
                favourites.add(rowMapper.rowToObject(rs));
            }
        }
        return favourites;
    }

    public Favourite getFavouriteById(long favouriteId) throws SQLException {
        String query = "SELECT * FROM favourites WHERE favouriteId = ?";
        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, favouriteId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    FavouriteRowMapper rowMapper = new FavouriteRowMapper();
                    return rowMapper.rowToObject(rs);
                }
            }
        }
        return null;
    }

    // Add more methods as needed (create, update, delete)
}
