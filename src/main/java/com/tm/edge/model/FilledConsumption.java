package com.tm.edge.model;

import java.util.List;

import com.tm.edge.model.*;

public class FilledConsumption {
    private String beerName;
    private String breweryName;
    private String beerType;
    private String beerDescription;
    private String beerPicture;
    private List<Consumption> consumptions;
    private User user;

    public FilledConsumption( Beer beer, List<Consumption> consumptions, User user) {
        setBeerName(beer.getName());
        setBreweryName(beer.getBrewery().getName());
        setBeerType(beer.getType());
        setBeerDescription(beer.getDescription());
        setBeerPicture(beer.getPicture());
        setConsumptions(consumptions);
        setUser(user);
    }

    public FilledConsumption(Beer beer, Consumption consumption) {
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public String getBreweryName() {
        return breweryName;
    }

    public void setBreweryName(String breweryName) {
        this.breweryName = breweryName;
    }

    public String getBeerType() {
        return beerType;
    }

    public void setBeerType(String beerType) {
        this.beerType = beerType;
    }

    public String getBeerDescription() {
        return beerDescription;
    }

    public void setBeerDescription(String beerDescription) {
        this.beerDescription = beerDescription;
    }

    public String getBeerPicture() {
        return beerPicture;
    }

    public void setBeerPicture(String beerPicture) {
        this.beerPicture = beerPicture;
    }

    public List<Consumption> getConsumptions() {
        return consumptions;
    }

    public void setConsumptions(List<Consumption> consumptions) {
        this.consumptions = consumptions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
