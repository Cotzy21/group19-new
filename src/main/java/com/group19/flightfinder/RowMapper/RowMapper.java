package com.group19.flightfinder;

import java.sql.ResultSet;

public interface RowMapper<T> {
    T rowToObject(ResultSet resultSet);
}
