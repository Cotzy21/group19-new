package com.group19.flightfinder.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    T rowToObject(ResultSet resultSet) throws SQLException;
}
