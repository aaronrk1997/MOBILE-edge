package com.tm.edge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${beerService.baseurl}")
    private String beerServiceBaseUrl;

    @Value("${consumptionservice.baseurl}")
    private String consumptionServiceBaseUrl;

    @Value("${userservice.baseurl}")
    private String userInfoServiceBaseUrl;

    // returns the list of all available beers
    @Getmapping("/beers")
    public List<Beer> getBeers() {
        ResponseEntity<List<Beer>> response = restTemplate.exchange(beerServiceBaseUrl + "/beers", HttpMethod.GET, null, new ParameterizedTypeReference<List<Beer>>() {
        });
        return response.getBody();
    }

    // returns the list of all breweries
    @GetMapping("/breweries")
    public List<Brewery> getBreweries() {
        ResponseEntity<List<Brewery>> response = restTemplate.exchange(beerServiceBaseUrl + "/breweries", HttpMethod.GET, null, new ParameterizedTypeReference<List<Brewery>>() {
        });
        return response.getBody();
    }

    // returns a list of all users
    @GetMapping("/users")
    public List<User> getUsers() {
        ResponseEntity<List<User>> response = restTemplate.exchange(userInfoServiceBaseUrl + "/users", HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        });
        return response.getBody();
    }

    
}
