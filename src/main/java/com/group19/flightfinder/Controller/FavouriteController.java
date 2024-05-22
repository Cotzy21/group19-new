package com.group19.flightfinder.Controller;

import com.group19.flightfinder.Entity.Favourite;
import com.group19.flightfinder.Service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favourites")
public class FavouriteController {

    @Autowired
    private FavouriteService favouriteService;

    @GetMapping
    public List<Favourite> getAllFavourites() {
        return favouriteService.getAllFavourites();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favourite> getFavouriteById(@PathVariable long id) {
        Favourite favourite = favouriteService.getFavouriteById(id);
        if (favourite != null) {
            return ResponseEntity.ok(favourite);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Favourite createFavourite(@RequestBody Favourite favourite) {
        return favouriteService.createFavourite(favourite);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Favourite> updateFavourite(@PathVariable long id, @RequestBody Favourite favouriteDetails) {
        Favourite updatedFavourite = favouriteService.updateFavourite(id, favouriteDetails);
        if (updatedFavourite != null) {
            return ResponseEntity.ok(updatedFavourite);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavourite(@PathVariable long id) {
        boolean deleted = favouriteService.deleteFavourite(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
