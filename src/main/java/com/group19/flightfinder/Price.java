package com.group19.flightfinder;

import jakarta.persistence.*;

@Entity
@Table(name= "Price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="priceId", nullable = false)
    private long priceId;

    Flight flightId = new Flight();
    long theFlightId = flightId.getFlightId();
    @Column(name="provider", nullable = false)
    private String provider;
    @Column(name= "value", nullable = false)
    private float  value;
    @Column(name = "currency", nullable = false)
    private String currency;

    public Price(){}

    public long getPriceId(){return priceId;}

    public String getProvider(){return provider;}

    public float getValue(){return value;}

    public String getCurrency(){return currency;}

    public void setPriceId(long priceId) {
        this.priceId = priceId;
    }
    public void setProvider(String provider){
        this.provider=provider;
    }
    public void setValue (float value){
        this.value = value;
    }
    public void setCurrency(String currency){
        this.currency=currency;
    }
}
