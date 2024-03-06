package com.example.introtestbackend.controller;
import com.example.introtestbackend.dto.CountryDTO;
import com.example.introtestbackend.model.Country;
import com.example.introtestbackend.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping
    public ResponseEntity<Country> addCountry(@RequestBody CountryDTO countryDTO) {

        if (countryDTO.getCountryName() == null || countryDTO.getCountryName().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Country name is required.");
        }

        Country country = new Country();
        country.setCountryName(countryDTO.getCountryName());
        country.setLastUpdate(countryDTO.getLastUpdate());

        Country savedCountry = countryRepository.save(country);
        return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
    }

}
