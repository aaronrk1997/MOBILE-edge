package com.tm.edge.model;

import java.util.Date;

public class User{
    private String id;
    private String name;
    private String firstName;
    private Date dateOfBirth;
    
    public User() {
    }

    public User(String name, String firstName, Date dateOfBirth) {
        setName(name);
        setFirstName(firstName);
        setDateOfBirth(dateOfBirth);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
