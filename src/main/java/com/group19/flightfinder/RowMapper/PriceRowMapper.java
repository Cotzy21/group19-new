package com.group19.flightfinder.RowMapper;

import com.group19.flightfinder.Entity.Price;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class PriceRowMapper implements RowMapper<Price> {
    @Override
    public Price rowToObject(ResultSet rs) throws SQLException {
        long priceId = rs.getLong("priceId");
        double amount = rs.getDouble("amount");
        LocalDateTime timestamp = rs.getTimestamp("timestamp").toLocalDateTime();

        Price price = new Price();
        price.setPriceId(priceId);
        price.setAmount(amount);
        price.setTimestamp(timestamp);

        return price;
    }
}
