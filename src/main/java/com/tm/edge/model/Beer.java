package com.tm.edge.model;

public class Beer {
    //---------------Attributes-----------------
    private Long beerId;
    private String beerName;
    private String description;
    private String picture;
    private String barcode;
    private float alcoholpercentage;
    private Brewery brewery;
    private String type;

    //---------------Constructors-----------------
    public Beer() {
        //Empty Constructor for jpa
    }

    public Beer(String beerName, String description, String picture, String barcode, float alcoholpercentage, Brewery brewery, String type) {
        setName(beerName);
        setDescription(description);
        setPicture(picture);
        setBarcode(barcode);
        setAlcoholpercentage(alcoholpercentage);
        setBrewery(brewery);
        setType(type);
    }

    public Long getId() {
        return beerId;
    }

    public void setId(Long id) {
        this.beerId = id;
    }

    public String getName() {
        return beerName;
    }

    public void setName(String beerName) {
        this.beerName = beerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public float getAlcoholpercentage() {
        return alcoholpercentage;
    }

    public void setAlcoholpercentage(float alcoholpercentage) {
        this.alcoholpercentage = alcoholpercentage;
    }

    public Brewery getBrewery() {
        return brewery;
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
