package com.group19.flightfinder.Controller;

import com.group19.flightfinder.Entity.Price;
import com.group19.flightfinder.Service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping
    public List<Price> getAllPrices() {
        return priceService.getAllPrices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Price> getPriceById(@PathVariable long id) {
        Price price = priceService.getPriceById(id);
        if (price != null) {
            return ResponseEntity.ok(price);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Price createPrice(@RequestBody Price price) {
        return priceService.createPrice(price);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Price> updatePrice(@PathVariable long id, @RequestBody Price priceDetails) {
        Price updatedPrice = priceService.updatePrice(id, priceDetails);
        if (updatedPrice != null) {
            return ResponseEntity.ok(updatedPrice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrice(@PathVariable long id) {
        boolean deleted = priceService.deletePrice(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
