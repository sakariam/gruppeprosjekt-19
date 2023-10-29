package org.example.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tours {
    private String title;
    private String description;
    private double price;

    private int capacity;


    public Tours() {
    }

    public Tours(String title, String description, double price, int capacity) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.capacity = capacity;
    }


    //Returns Tour details
    @Override
    public String toString(){
        return "Tour title:" + title + "\nDescription: " + description + "\nPrice: " + price + "kr"; //+ guide.getName() Add this after we add getName in Guide class
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}