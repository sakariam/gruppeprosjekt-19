package org.example.Model;

import java.util.List;

public class Guide {
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private String description;
    private List<rating> rate;
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

    public void addrating(){

    }

    private void changeDescription(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}