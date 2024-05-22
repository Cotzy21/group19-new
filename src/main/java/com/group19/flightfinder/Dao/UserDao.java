package com.group19.flightfinder.Dao;

import com.group19.flightfinder.Entity.User;
import com.group19.flightfinder.JdbcConnection;
import com.group19.flightfinder.RowMapper.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {
    private JdbcConnection jdbcConnection;

    public UserDao() {
        this.jdbcConnection = JdbcConnection.getInstance();
    }

    public List<User> getAllUsers() throws SQLException {
        String query = "SELECT * FROM users";
        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            UserRowMapper rowMapper = new UserRowMapper();
            return new JdbcTemplate().query(query, rowMapper);
        }
    }

    public User getUserById(long userId) throws SQLException {
        String query = "SELECT * FROM users WHERE userId = ?";
        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    UserRowMapper rowMapper = new UserRowMapper();
                    return rowMapper.mapRow(rs, 1);
                }
            }
        }
        return null;
    }

    // Add more methods as needed (create, update, delete)
}
