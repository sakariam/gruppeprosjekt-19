package org.example.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Model.Guide;
import org.example.Model.Tours;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ToursJSONRepository implements ToursRepository {
    private final String filename;//Filename for the JSON file
    private ArrayList<Tours> tours = new ArrayList<>(); //List to store Tours objects


    public ToursJSONRepository(String filename) {
        this.filename = filename;
        // Read existing Tours data from the JSON file and add it to the tours list
        List<Tours> existingTours = readJsonFile(filename);
        if (existingTours != null) {
            tours.addAll(existingTours);
        }
    }
    //Method to read Tours data from a JSON file
    public List<Tours> readJsonFile(String filename) {
        List<Guide> guidesList = new ArrayList<>(); // Stores Guide objects
        List<Tours> toursList = new ArrayList<>(); // Stores Tours objects
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File file = new File(filename);

            // Read data from the JSON file and convert it to an array of Guide objects.
            if (file.exists() && file.length() > 0) {
                Guide[] list = objectMapper.readValue(file, Guide[].class);
                // Extract Tours objects from the Guide objects and add them to the 'toursList'.
                guidesList = Arrays.asList(list);
                for (Guide guide : guidesList) {
                    toursList.addAll(guide.getTourGuides());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // Returns tourList if not empty, returns null if empty
        return toursList.isEmpty() ? null : toursList;
    }
    // Method to write to JSON file
    public static void writeToJson(String filename, List<Tours> tours){
        File file = new File(filename);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, tours);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    //***Implementations from TourRepository interface***

    //Method to add tour
    @Override
    public void addTour(Tours tour){
        // Adds a Tour object to tours list
        tours.add(tour);

        // Writes updated tour list to JSON file
        writeToJson(filename,tours);
    }

    @Override
    public void delTour(int index) {
        if (index >= 0 && index < tours.size()) {
            // Removes a Tour that is at the index in the tours list
            tours.remove(index);
            // Writes updated list to JSON file
            writeToJson(filename, tours);
        }
    }
    @Override
    public List<Tours> getAllTours() {
        return new ArrayList<>(tours);
    }

    public Tours getTour(int index) {
        if (index >= 0 && index < tours.size()) {
            return tours.get(index);
        }
        return null;
    }

    public void clearAllTours() {
        tours.clear();
        writeToJson(filename, tours);
    }
}