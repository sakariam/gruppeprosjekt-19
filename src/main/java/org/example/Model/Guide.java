package org.example.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Guide {

    private String name;
    private String description;
    private ArrayList<Tours> TourGuides;


// TODO: 26.09.2023 Lag constructer, getters og setters etter alle variablene
    public Guide() {

    }

    public Guide(String name, String description, ArrayList<Tours> tourGuides) {
        this.name = name;
        this.description = description;
        this.TourGuides = tourGuides;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Tours> getTourGuides() {
        return TourGuides;
    }

    public void setTourGuides(ArrayList<Tours> tourGuides) {
        TourGuides = tourGuides;
    }
}

