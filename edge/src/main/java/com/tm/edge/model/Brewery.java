package com.tm.edge.model;

import java.util.List;

public class Brewery {

    //---------------Attributes-----------------

    private Long breweryId;

    private String name;

    private String description;

    private String logo;
    private List<Beer> beers;

    //---------------Constructors-----------------
    public Brewery() {
        //Empty Constructor for jpa
    }

    public Brewery(String name, String description, String logo, List<Beer> beers) {
        setName(name);
        setDescription(description);
        setLogo(logo);
        setBeers(beers);
    }

    //---------------Getters and Setters-----------------

    public Long getBreweryId() {
        return this.breweryId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Beer> getBeers() {
        return this.beers;
    }

    public void setBeers(List<Beer> beers) {
        this.beers = beers;
    }
    

    //---------------Use cases-----------------


}

