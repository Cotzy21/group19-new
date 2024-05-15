package com.group19.flightfinder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Favourite")
public class Favourite {
    @Id
    @GeneratedValue
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
