package com.example.introtestbackend.dto;

import java.time.LocalDateTime;

public class CountryDTO {

    private String countryName;
    private LocalDateTime lastUpdate;

    // Constructors, getters, and setters
    public CountryDTO() {}

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
