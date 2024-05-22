package com.group19.flightfinder.Entity;

import com.group19.flightfinder.Entity.Flight;
import jakarta.persistence.*;

@Entity
@Table(name = "favourites")
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favouriteId", nullable = false)
    private long favouriteId;

    @ManyToOne
    @JoinColumn(name = "flightId")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Favourite() {}

    public long getFavouriteId() {
        return favouriteId;
    }

    public void setFavouriteId(long favouriteId) {
        this.favouriteId = favouriteId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
