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

    
}