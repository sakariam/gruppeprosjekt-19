package org.example.Repository;

import org.example.Model.Tours;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ToursJSONRepository implements ToursRepository {
    private final String filename;
    private ArrayList<Tours> tours = new ArrayList<>();


    public ToursJSONRepository(String filename) {
        this.filename = filename;
        List<Tours> existingTours = readJsonFile(filename);
        if (existingTours != null) {
            tours.addAll(existingTours);
        }
    }

    public List<Tours> readJsonFile(String filename) {
        List<Tours> toursList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File file = new File(filename);

            if (file.exists() && file.length() > 0) {
                Tours[] list = objectMapper.readValue(file, Tours[].class);
                toursList = Arrays.asList(list);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return toursList.isEmpty() ? null : toursList;
    }

    public static void writeToJson(String filename, List<Tours> tours){
        File file = new File(filename);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, tours);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @Override
    public void addTour(Tours tour){
        tours.add(tour);

        writeToJson("src/data/tour.json",tours);
    }


}