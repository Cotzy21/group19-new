package com.group19.flightfinder.RowMapper;

import com.group19.flightfinder.Entity.Favourite;
import com.group19.flightfinder.Entity.Flight;
import com.group19.flightfinder.Entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FavouriteRowMapper implements RowMapper<Favourite> {
    @Override
    public Favourite rowToObject(ResultSet rs) throws SQLException {
        long favouriteId = rs.getLong("favouriteId");

        long flightId = rs.getLong("flightId");
        Flight flight = new Flight();
        flight.setFlightId(flightId);

        long userId = rs.getLong("userId");
        User user = new User();
        user.setId(userId);

        Favourite favourite = new Favourite();
        favourite.setFavouriteId(favouriteId);
        favourite.setFlight(flight);
        favourite.setUser(user);

        return favourite;
    }
}
