package org.example.Repository;

import org.example.Model.Tours;

import java.util.ArrayList;

public interface ToursRepository {


    void addTour(Tours tour);

    void delTour(int index);


    ArrayList<Tours> getAllTours();
}