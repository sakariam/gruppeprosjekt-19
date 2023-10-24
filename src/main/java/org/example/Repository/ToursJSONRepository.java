package org.example.Repository;

import org.example.Model.Tours;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ToursJSONRepository implements ToursRepository {
    private ArrayList<Tours> tours = new ArrayList<>();


    public ToursJSONRepository(String filename){
        tours.addAll(readJsonFile(filename));
    }

    public List<Tours> readJsonFile(String filename) {
        List<Tours> ToursList = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Tours[] list = objectMapper.readValue(new File(filename), Tours[].class);

            ToursList = Arrays.asList(list);

        } catch (IOException e) {
            e.printStackTrace();

        }
        return ToursList;
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


}