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
import com.tm.edge.model.Consumption;
import com.tm.edge.model.FilledConsumption;

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

    //TODO REQUEST ALL SCORES PER BEER
    @GetMapping("/beers")
    public List<Beer> getBeers() {
        ResponseEntity<List<Beer>> response = restTemplate.exchange("http://"+ beerServiceBaseUrl + "/beers", HttpMethod.GET, null, new ParameterizedTypeReference<List<Beer>>() {
        });
        return response.getBody();
    }

    @GetMapping("/beers/{beerName}")
    public Beer getBeerByName(@PathVariable String beerName) {
        ResponseEntity<Beer> response = restTemplate.exchange("http://"+ beerServiceBaseUrl + "/beers/{beerName}", HttpMethod.GET, null, new ParameterizedTypeReference<Beer>() {
        }, beerName);
        return response.getBody();
    }

    @GetMapping("/beers/search/{beerName}")
    public List<Beer> getBeerBySearch(@PathVariable String beerName) {
        ResponseEntity<List<Beer>> response = restTemplate.exchange("http://"+ beerServiceBaseUrl + "/beers/search/" + beerName, HttpMethod.GET, null, new ParameterizedTypeReference<List<Beer>>() {
        });
        return response.getBody();
    }

    @PostMapping("/beers")
    public Beer addBeer(@RequestBody Beer beer) {
        ResponseEntity<Beer> response = restTemplate.exchange("http://"+ beerServiceBaseUrl + "/beers", HttpMethod.POST, new HttpEntity<>(beer), new ParameterizedTypeReference<Beer>() {
        });
        return response.getBody();
    }

    @PutMapping("/beers/{beerName}")
    public Beer updateBeer(@PathVariable String beerName, @RequestBody Beer beer) {
        ResponseEntity<Beer> response = restTemplate.exchange("http://"+ beerServiceBaseUrl + "/beers/" + beerName, HttpMethod.PUT, new HttpEntity<>(beer), new ParameterizedTypeReference<Beer>() {
        });
        return response.getBody();
    }

    @DeleteMapping("/beers/{beerName}")
    public void deleteBeer(@PathVariable String beerName) {
        restTemplate.exchange("http://"+ beerServiceBaseUrl + "/beers/" + beerName, HttpMethod.DELETE, null, new ParameterizedTypeReference<Beer>() {
        });
    }

    // returns the list of all breweries
    @GetMapping("/breweries")
    public List<Brewery> getBreweries() {
        ResponseEntity<List<Brewery>> response = restTemplate.exchange("http://"+ beerServiceBaseUrl + "/breweries", HttpMethod.GET, null, new ParameterizedTypeReference<List<Brewery>>() {
        });
        return response.getBody();
    }

    @GetMapping("/breweries/{name}")
    public Brewery getBreweryByName(@PathVariable String name) {
        ResponseEntity<Brewery> response = restTemplate.exchange("http://"+ beerServiceBaseUrl + "/breweries/" + name, HttpMethod.GET, null, new ParameterizedTypeReference<Brewery>() {
        });
        return response.getBody();
    }

    @GetMapping("/breweries/search/{name}")
    public List<Brewery> getBreweryBySearch(@PathVariable String name) {
        ResponseEntity<List<Brewery>> response = restTemplate.exchange("http://"+ beerServiceBaseUrl + "/breweries/search/" + name, HttpMethod.GET, null, new ParameterizedTypeReference<List<Brewery>>() {
        });
        return response.getBody();
    }

    @PostMapping("/breweries")
    public Brewery addBrewery(@RequestBody Brewery brewery) {
        ResponseEntity<Brewery> response = restTemplate.exchange("http://"+ beerServiceBaseUrl + "/breweries", HttpMethod.POST, new HttpEntity<>(brewery), new ParameterizedTypeReference<Brewery>() {
        });
        return response.getBody();
    }

    @PutMapping("/breweries/{name}")
    public Brewery updateBrewery(@PathVariable String name, @RequestBody Brewery brewery) {
        ResponseEntity<Brewery> response = restTemplate.exchange("http://"+ beerServiceBaseUrl + "/breweries/" + name, HttpMethod.PUT, new HttpEntity<>(brewery), new ParameterizedTypeReference<Brewery>() {
        });
        return response.getBody();
    }

    @DeleteMapping("/breweries/{name}")
    public void deleteBrewery(@PathVariable String name) {
        restTemplate.exchange("http://"+ beerServiceBaseUrl + "/breweries/" + name, HttpMethod.DELETE, null, new ParameterizedTypeReference<Brewery>() {
        });
    }

    // returns a list of all users
    @GetMapping("/users")
    public List<User> getUsers() {
        ResponseEntity<List<User>> response = restTemplate.exchange("http://"+ userInfoServiceBaseUrl + "/users", HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        });
        return response.getBody();
    }

    @GetMapping("/users/{name}")
    public User getUserByName(@PathVariable String name) {
        ResponseEntity<User> response = restTemplate.exchange("http://"+ userInfoServiceBaseUrl + "/users/" + name, HttpMethod.GET, null, new ParameterizedTypeReference<User>() {
        });
        return response.getBody();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        ResponseEntity<User> response = restTemplate.exchange("http://"+ userInfoServiceBaseUrl + "/users", HttpMethod.POST, new HttpEntity<>(user), new ParameterizedTypeReference<User>() {
        });
        return response.getBody();
    }

    @PutMapping("/users/{name}")
    public User updateUser(@PathVariable String name, @RequestBody User user) {
        ResponseEntity<User> response = restTemplate.exchange("http://"+ userInfoServiceBaseUrl + "/users/" + name, HttpMethod.PUT, new HttpEntity<>(user), new ParameterizedTypeReference<User>() {
        });
        return response.getBody();
    }

    @DeleteMapping("/users/{name}")
    public void deleteUser(@PathVariable String name) {
        restTemplate.exchange("http://"+ userInfoServiceBaseUrl + "/users/" + name, HttpMethod.DELETE, null, new ParameterizedTypeReference<User>() {
        });
    }
    // returns a list of all consumptions
    @GetMapping("/consumptions")
    public List<FilledConsumption> getConsumptions() {

        List<FilledConsumption> filledConsumptions = new ArrayList<>();
        ResponseEntity<List<Consumption>> response = restTemplate.exchange("http://"+ consumptionServiceBaseUrl + "/consumptions", HttpMethod.GET, null, new ParameterizedTypeReference<List<Consumption>>() {
        });

        List<Consumption> consumptions = response.getBody();

        for (Consumption consumption: consumptions){
            Beer beer = restTemplate.getForObject("http://"+ beerServiceBaseUrl + "/beers/id/{id}", Beer.class,consumption.getBeerId());
            filledConsumptions.add(new FilledConsumption(beer, consumption));
        }
        return filledConsumptions;
    }

    //get consumption by user
    @GetMapping("/consumptions/user/{userId}")
    public List<FilledConsumption> getConsumptionsByUser(@PathVariable String userId) {

        List<FilledConsumption> filledConsumptions = new ArrayList<>();
        ResponseEntity<List<Consumption>> response = restTemplate.exchange("http://"+ consumptionServiceBaseUrl + "/consumptions/user/" + userId, HttpMethod.GET, null, new ParameterizedTypeReference<List<Consumption>>() {
        });
        List<Consumption> consumptions = response.getBody();

        for (Consumption consumption: consumptions){
            Beer beer = restTemplate.getForObject("http://"+ beerServiceBaseUrl + "/beers/id/{id}", Beer.class,consumption.getBeerId());
            filledConsumptions.add(new FilledConsumption(beer, consumption));
        }
        return filledConsumptions;
        
    }

    //get consumption by beer
    @GetMapping("/consumptions/beer/{beerId}")
    public List<FilledConsumption> getConsumptionsByBeer(@PathVariable String beerId) {

        List<FilledConsumption> filledConsumptions = new ArrayList<>();
        ResponseEntity<List<Consumption>> response = restTemplate.exchange("http://"+ consumptionServiceBaseUrl + "/consumptions/beer/" + beerId, HttpMethod.GET, null, new ParameterizedTypeReference<List<Consumption>>() {
        });
        List<Consumption> consumptions = response.getBody();

        for (Consumption consumption: consumptions){
            Beer beer = restTemplate.getForObject("http://"+ beerServiceBaseUrl + "/beers/id/{id}", Beer.class,consumption.getBeerId());
            filledConsumptions.add(new FilledConsumption(beer, consumption));
        }
        return filledConsumptions;
    }

    //get consumption by beer and user
    @GetMapping("/consumptions/user/{userId}/beer/{beer}")
    public FilledConsumption getConsumptionsByBeerAndUser(@PathVariable String userId, @PathVariable String beer) {
        ResponseEntity<Consumption> response = restTemplate.exchange("http://"+ consumptionServiceBaseUrl + "/consumptions/user/" + userId + "/beer/" + beer, HttpMethod.GET, null, new ParameterizedTypeReference<Consumption>() {
        });

        Consumption consumption = response.getBody();
        Beer beerfound = restTemplate.getForObject("http://"+ beerServiceBaseUrl + "/beers/id/{id}", Beer.class, consumption.getBeerId());
        return new FilledConsumption(beerfound, consumption);
    }

    @GetMapping("/consumptions/{id}")
    public FilledConsumption getConsumptionById(@PathVariable String id) {
        ResponseEntity<Consumption> response = restTemplate.exchange("http://"+ consumptionServiceBaseUrl + "/consumptions/" + id, HttpMethod.GET, null, new ParameterizedTypeReference<Consumption>() {
        });

        Consumption consumption = response.getBody();
        Beer beer = restTemplate.getForObject("http://"+ beerServiceBaseUrl + "/beers/id/{id}", Beer.class, consumption.getBeerId());
        return new FilledConsumption(beer, consumption);
    }

    @PostMapping("/consumptions")
    public Consumption addConsumption(@RequestBody Consumption consumption) {
        ResponseEntity<Consumption> response = restTemplate.exchange("http://"+ consumptionServiceBaseUrl + "/consumptions", HttpMethod.POST, new HttpEntity<>(consumption), new ParameterizedTypeReference<Consumption>() {
        });
        return response.getBody();
    }

    @PutMapping("/consumptions/{id}")
    public Consumption updateConsumption(@RequestBody Consumption consumption, @PathVariable String id) {
        ResponseEntity<Consumption> response = restTemplate.exchange("http://"+ consumptionServiceBaseUrl + "/consumptions/" + id, HttpMethod.PUT, new HttpEntity<>(consumption), new ParameterizedTypeReference<Consumption>() {
        });
        return response.getBody();
    }

    @DeleteMapping("/consumptions/{id}")
    public void deleteConsumption(@PathVariable String id) {
        restTemplate.exchange("http://"+ consumptionServiceBaseUrl + "/consumptions/" + id, HttpMethod.DELETE, null, new ParameterizedTypeReference<Consumption>() {
        });
    }



}
