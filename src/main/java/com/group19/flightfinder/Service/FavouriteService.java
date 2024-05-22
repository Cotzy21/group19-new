package com.group19.flightfinder.Service;

import com.group19.flightfinder.Entity.Favourite;
import com.group19.flightfinder.Repositories.FavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteService {

    @Autowired
    private FavouriteRepository favouriteRepository;

    public List<Favourite> getAllFavourites() {
        return favouriteRepository.findAll();
    }

    public Favourite getFavouriteById(long id) {
        return favouriteRepository.findById(id).orElse(null);
    }

    public Favourite createFavourite(Favourite favourite) {
        return favouriteRepository.save(favourite);
    }

    public Favourite updateFavourite(long id, Favourite favouriteDetails) {
        Favourite favourite = favouriteRepository.findById(id).orElse(null);
        if (favourite != null) {
            favourite.setUser(favouriteDetails.getUser());
            favourite.setFlight(favouriteDetails.getFlight());
            return favouriteRepository.save(favourite);
        }
        return null;
    }

    public boolean deleteFavourite(long id) {
        if (favouriteRepository.existsById(id)) {
            favouriteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
