package org.example.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tours {
    private int tourId;
    private String tourName;
    private String description;
    private double price;
    private Guide guide;
    private int capacity;
    private List<User> bookedUsers;

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
    //Returns Tour details
    public String getTourDetails(){
        return "Tour title:" + tourName + "\nDescription: " + description + "\nPrice: " + price + "kr"; //+ guide.getName() Add this after we add getName in Guide class
    }
    //Returns how much the guide will get from the tour
    public double getTourRevenue(){
        return bookedUsers.size() * price;
    }

    //Getters and setter
    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
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

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<User> getBookedUsers() {
        return bookedUsers;
    }

    public void setBookedUsers(List<User> bookedUsers) {
        this.bookedUsers = bookedUsers;
    }

}