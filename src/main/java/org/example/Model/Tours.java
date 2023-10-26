package org.example.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tours {
    private String title;
    private String description;
    private double price;

    private int capacity;
    //private List<User> bookedUsers;

    public Tours() {
    }

    public Tours(String title, String description, double price, int capacity) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.capacity = capacity;
    }
    /*
    //Checking if there are any spots left in the tour
    public boolean isAvailable(){
        return bookedUsers.size() < capacity;
    }
    //Adding user to the tour
    public boolean userBookTour(User user){
        if (bookedUsers.size() < capacity){
            bookedUsers.add(user);
            return true;
        }
        else {
            return false;
        }
    }
    //removing user from tour
    public boolean userCancelTour(User user) {
        if (bookedUsers.contains(user)) {
            bookedUsers.remove(user);
            return true;
        } else {
            return false;
        }
    }
    //Checks for how many spots left in the tour
    public int getAvailableSpots(){
        return capacity - bookedUsers.size();
    }
       public double getTourRevenue(){
        return bookedUsers.size() * price;
    }
    */
    //Returns Tour details
    @Override
    public String toString(){
        return "Tour title:" + title + "\nDescription: " + description + "\nPrice: " + price + "kr"; //+ guide.getName() Add this after we add getName in Guide class
    }
    //Returns how much the guide will get from the tour

/*
    //Getters and setter
    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }
*/
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
/*
    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }
*/
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    /*
    public List<User> getBookedUsers() {
        return bookedUsers;
    }

    public void setBookedUsers(List<User> bookedUsers) {
        this.bookedUsers = bookedUsers;
    }
    */
}