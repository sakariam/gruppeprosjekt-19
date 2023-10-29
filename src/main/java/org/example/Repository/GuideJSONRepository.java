package org.example.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Model.Guide;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuideJSONRepository implements GuideRepository {
    private final String filename; // Name of JSON file to store guides
    private ArrayList<Guide> guides = new ArrayList<>(); // Stores Guide objects

    public GuideJSONRepository(String filename) {
        this.filename = filename;
        // Reads existing guides from JSON file and adds them to guides list
        List<Guide> existingGuides = readJsonFile(filename);
        if (existingGuides != null) {
            guides.addAll(existingGuides);
        }
    }
    //Method to read JSON file
    public List<Guide> readJsonFile(String filename) {
        List<Guide> guideList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File file = new File(filename);

            //Checks if file exists and isn't empty
            if (file.exists() && file.length() > 0) {
                Guide[] list = objectMapper.readValue(file, Guide[].class);
                guideList = Arrays.asList(list);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // Returns guideList if not empty, returns null if empty

        return guideList.isEmpty() ? null : guideList;
    }
    // Methods to write to JSON file
    public static void writeToJson(String filename, List<Guide> guides) {
        File file = new File(filename);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, guides);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //***Implementations from GuideRepository interface***

    // Method to add guide
    @Override
    public void addGuide(Guide guide) {
        // Adds a Guide object to guide list
        guides.add(guide);
        // Writes updated tour list to JSON file
        writeToJson(filename, guides);
    }
    // Method that deletes Guide
    @Override
    public void delGuide(int index) {
        if (index >= 0 && index < guides.size()) {
            // Removes a Guide that is at the index in the guide list
            guides.remove(index);
            writeToJson(filename, guides);
        }
    }
    // Returs a list of all guides
    @Override
    public ArrayList<Guide> getAllGuides() {
        return guides;
    }
    // Updates a guide in the list and writes the updated list to JSON file
    @Override
    public void updateGuide(Guide guide) {
        int index = guides.indexOf(guide);
        if (index >= 0) {
            guides.set(index, guide);
            writeToJson(filename, guides);
        }
    }
}