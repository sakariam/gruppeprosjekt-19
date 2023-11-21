package org.example.Repository;

import org.example.Model.Tours;
import java.util.Arrays;
import java.util.List;

import java.util.List;

public interface ToursRepository {

    void addTour(Tours tour);

    void delTour(int index);
    List<Tours> getAllTours();

    List<Tours> getAllTours();

}