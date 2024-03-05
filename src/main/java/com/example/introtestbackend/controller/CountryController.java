package com.example.introtestbackend.controller;
import com.example.introtestbackend.model.Country;
import com.example.introtestbackend.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    // GET request to retrieve all countries
    @GetMapping
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

}
