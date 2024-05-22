package com.group19.flightfinder.Service;

import com.group19.flightfinder.Entity.Price;
import com.group19.flightfinder.Repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    public Price getPriceById(long id) {
        return priceRepository.findById(id).orElse(null);
    }

    public Price createPrice(Price price) {
        return priceRepository.save(price);
    }

    public Price updatePrice(long id, Price priceDetails) {
        Price price = priceRepository.findById(id).orElse(null);
        if (price != null) {
            price.setAmount(priceDetails.getAmount());
            price.setTimestamp(priceDetails.getTimestamp());
            return priceRepository.save(price);
        }
        return null;
    }

    public boolean deletePrice(long id) {
        if (priceRepository.existsById(id)) {
            priceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
