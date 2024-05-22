package com.group19.flightfinder.RowMapper;

import com.group19.flightfinder.Entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserId(rs.getLong("userId"));
        user.setUsername(rs.getString("username"));
        user.setPasswordHash(rs.getString("password"));
        // Add other fields as necessary
        return user;
    }
}
