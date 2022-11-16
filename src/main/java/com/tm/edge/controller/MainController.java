package com.tm.edge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.tm.edge.model.Beer;
import com.tm.edge.model.Brewery;
import com.tm.edge.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${beerservice.baseurl}")
    private String beerServiceBaseUrl;

    @Value("${consumptionservice.baseurl}")
    private String consumptionServiceBaseUrl;

    @Value("${userservice.baseurl}")
    private String userInfoServiceBaseUrl;

    // returns the list of all available beers
    @GetMapping("/beers")
    public List<Beer> getBeers() {
        ResponseEntity<List<Beer>> response = restTemplate.exchange(beerServiceBaseUrl + "/beers", HttpMethod.GET, null, new ParameterizedTypeReference<List<Beer>>() {
        });
        return response.getBody();
    }

    @GetMapping("/beers/{name}")
    public Beer getBeerByName(@PathVariable String name) {
        ResponseEntity<Beer> response = restTemplate.exchange(beerServiceBaseUrl + "/beers/" + name, HttpMethod.GET, null, new ParameterizedTypeReference<Beer>() {
        });
        return response.getBody();
    }

    @GetMapping("/beers/search/{name}")
    public List<Beer> getBeerBySearch(@PathVariable String name) {
        ResponseEntity<List<Beer>> response = restTemplate.exchange(beerServiceBaseUrl + "/beers/search/" + name, HttpMethod.GET, null, new ParameterizedTypeReference<List<Beer>>() {
        });
        return response.getBody();
    }

    @PostMapping("/beers")
    public Beer addBeer(@RequestBody Beer beer) {
        ResponseEntity<Beer> response = restTemplate.exchange(beerServiceBaseUrl + "/beers", HttpMethod.POST, new HttpEntity<>(beer), new ParameterizedTypeReference<Beer>() {
        });
        return response.getBody();
    }

    @PutMapping("/beers/{name}")
    public Beer updateBeer(@PathVariable String name, @RequestBody Beer beer) {
        ResponseEntity<Beer> response = restTemplate.exchange(beerServiceBaseUrl + "/beers/" + name, HttpMethod.PUT, new HttpEntity<>(beer), new ParameterizedTypeReference<Beer>() {
        });
        return response.getBody();
    }

    @DeleteMapping("/beers/{name}")
    public void deleteBeer(@PathVariable String name) {
        restTemplate.exchange(beerServiceBaseUrl + "/beers/" + name, HttpMethod.DELETE, null, new ParameterizedTypeReference<Beer>() {
        });
    }

    // returns the list of all breweries
    @GetMapping("/breweries")
    public List<Brewery> getBreweries() {
        ResponseEntity<List<Brewery>> response = restTemplate.exchange(beerServiceBaseUrl + "/breweries", HttpMethod.GET, null, new ParameterizedTypeReference<List<Brewery>>() {
        });
        return response.getBody();
    }

    @GetMapping("/breweries/{name}")
    public Brewery getBreweryByName(@PathVariable String name) {
        ResponseEntity<Brewery> response = restTemplate.exchange(beerServiceBaseUrl + "/breweries/" + name, HttpMethod.GET, null, new ParameterizedTypeReference<Brewery>() {
        });
        return response.getBody();
    }

    @GetMapping("/breweries/search/{name}")
    public List<Brewery> getBreweryBySearch(@PathVariable String name) {
        ResponseEntity<List<Brewery>> response = restTemplate.exchange(beerServiceBaseUrl + "/breweries/search/" + name, HttpMethod.GET, null, new ParameterizedTypeReference<List<Brewery>>() {
        });
        return response.getBody();
    }

    @PostMapping("/breweries")
    public Brewery addBrewery(@RequestBody Brewery brewery) {
        ResponseEntity<Brewery> response = restTemplate.exchange(beerServiceBaseUrl + "/breweries", HttpMethod.POST, new HttpEntity<>(brewery), new ParameterizedTypeReference<Brewery>() {
        });
        return response.getBody();
    }

    @PutMapping("/breweries/{name}")
    public Brewery updateBrewery(@PathVariable String name, @RequestBody Brewery brewery) {
        ResponseEntity<Brewery> response = restTemplate.exchange(beerServiceBaseUrl + "/breweries/" + name, HttpMethod.PUT, new HttpEntity<>(brewery), new ParameterizedTypeReference<Brewery>() {
        });
        return response.getBody();
    }

    @DeleteMapping("/breweries/{name}")
    public void deleteBrewery(@PathVariable String name) {
        restTemplate.exchange(beerServiceBaseUrl + "/breweries/" + name, HttpMethod.DELETE, null, new ParameterizedTypeReference<Brewery>() {
        });
    }

    // returns a list of all users
    @GetMapping("/users")
    public List<User> getUsers() {
        ResponseEntity<List<User>> response = restTemplate.exchange(userInfoServiceBaseUrl + "/users", HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        });
        return response.getBody();
    }

    @GetMapping("/users/{name}")
    public User getUserByName(@PathVariable String name) {
        ResponseEntity<User> response = restTemplate.exchange(userInfoServiceBaseUrl + "/users/" + name, HttpMethod.GET, null, new ParameterizedTypeReference<User>() {
        });
        return response.getBody();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        ResponseEntity<User> response = restTemplate.exchange(userInfoServiceBaseUrl + "/users", HttpMethod.POST, new HttpEntity<>(user), new ParameterizedTypeReference<User>() {
        });
        return response.getBody();
    }

    @PutMapping("/users/{name}")
    public User updateUser(@PathVariable String name, @RequestBody User user) {
        ResponseEntity<User> response = restTemplate.exchange(userInfoServiceBaseUrl + "/users/" + name, HttpMethod.PUT, new HttpEntity<>(user), new ParameterizedTypeReference<User>() {
        });
        return response.getBody();
    }

    @DeleteMapping("/users/{name}")
    public void deleteUser(@PathVariable String name) {
        restTemplate.exchange(userInfoServiceBaseUrl + "/users/" + name, HttpMethod.DELETE, null, new ParameterizedTypeReference<User>() {
        });
    }
}
