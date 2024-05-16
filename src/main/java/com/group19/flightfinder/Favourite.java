package com.group19.flightfinder;

import jakarta.persistence.*;

@Entity
@Table(name="Favourite")
public class Favourite {
    @Id
    @GeneratedValue
    @Column(name="favouriteId", nullable = false)
    private long favouriteId;

    User userId = new User();
    long theUserId = userId.getUserId();
    Flight flightId = new Flight();
    long theFlightId = flightId.getFlightId();

    public Favourite(){}

    public long getFavouriteId(){return favouriteId;}

    public void setFavouriteId(long favouriteId){
        this.favouriteId = favouriteId;
    }

}
