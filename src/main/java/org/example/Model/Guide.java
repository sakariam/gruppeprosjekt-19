package org.example.Model;

import java.util.List;

public class Guide {
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private String description;
    private List<Tours> TourGuides;

    public Guide(int id, String name, String email, String phoneNumber, String description, List<Tours> tourGuides) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.description = description;
        TourGuides = tourGuides;
    }


// TODO: 26.09.2023 Lag constructer, getters og setters etter alle variablene

    public void addTour(){

    }
    public void removeTour(){

    }
    private void changeDescription(){

    }

}