package org.example.Model;

import java.util.List;


public class User {
    public User(int id, String username, String first_name, String last_name, List<Tours> favorite_tours) {
        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.favorite_tours = favorite_tours;
    }

    private int id;
    private String username;
    private String first_name;
    private String last_name;
    private List<Tours> favorite_tours;
    // TODO: 26.09.2023 Lag constructer, getters og setters etter alle variablene







    public void makeProfile(){

    }
    public void deleteProfile(){

    }
    public void addFavoriteTour(){

    }
    public void removeFavoriteTour(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public List<Tours> getFavorite_tours() {
        return favorite_tours;
    }

    public void setFavorite_tours(List<Tours> favorite_tours) {
        this.favorite_tours = favorite_tours;
    }
}


