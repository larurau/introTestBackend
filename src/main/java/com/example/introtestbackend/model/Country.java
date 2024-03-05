package com.example.introtestbackend.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int countryID;

    @Column(name = "country")
    private String countryName;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    // Constructors, getters and setters
    public Country(){
    }

    public Country(String countryName, LocalDateTime lastUpdate) {
        this.countryName = countryName;
        this.lastUpdate = lastUpdate;
    }

    public int getCountryID() {
        return countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Country [country_id=" + countryID + ", countryName=" + countryName + ", last_update=" + lastUpdate + "]";
    }

}
