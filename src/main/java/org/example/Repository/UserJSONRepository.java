package org.example.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Model.Users;
import org.example.Model.Tours;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserJSONRepository implements UserRepository {
    private final String filename; // Name of JSON file to store users
    private ArrayList<Users> users = new ArrayList<>(); // Stores User objects

    public UserJSONRepository(String filename) {
        this.filename = filename;
        // leser bruker som er allerede JSON File og legger dem til i bruker lista
        List<Users> existingUsers = readJsonFile(filename);
        if (existingUsers != null) {
            users.addAll(existingUsers);
        }
    }

    // JSON file methode
    public List<Users> readJsonFile(String filename) {
        List<Users> userList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File file = new File(filename);

            // Checks if the file exists and isn't empty
            if (file.exists() && file.length() > 0) {
                Users[] list = objectMapper.readValue(file, Users[].class);
                userList = Arrays.asList(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Returns userList if not empty, returns null if empty
        return userList.isEmpty() ? null : userList;
    }

    // Method to write to JSON file
    public void writeToJson(String filename, List<Users> users) {
        File file = new File(filename);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Implementations from UserRepository interface

    @Override
    public void addUser(Users user) {
        // Adds a User object to the users list
        users.add(user);
        // Writes the updated user list to the JSON file
        writeToJson(filename, users);
    }

    @Override
    public void deleteUser(String username) {
        Users userToDelete = null;
        for (Users user : users) {
            if (user.getUsername().equals(username)) {
                userToDelete = user;
                break;
            }
        }

        if (userToDelete != null) {

            users.remove(userToDelete);

            writeToJson(filename, users);
        }
    }

    @Override
    public String purchaseBooking() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the guide's name: ");
        String guideName = scanner.nextLine();

        System.out.print("How many people?: ");
        int numberOfPeople = scanner.nextInt();

        System.out.print("The price: ");
        double price = scanner.nextDouble();

        System.out.print("Is the information correct? (yes/no): ");
        String confirmation = scanner.next();

        scanner.close();

        if (confirmation.equalsIgnoreCase("yes")) {
            String booking = "Guide: " + guideName + "\n";
            booking += "How many people?: " + numberOfPeople + "\n";
            booking += "Price: " + price + "\n";


            return booking;
        }  else {
            return "booking is not confirmed. try again";
        }

    }

    @Override
    public Users getUser(String username) {
        for (Users user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        return users;
    }

    // New method to get ordered tours for a user
    @Override
    public List<Tours> getOrderedTours(Users user) {
        return getOrderedTours(user);
    }

    // New method to update user information
    @Override
    public void updateUser(Users user) {
        writeToJson(filename, users);
    }


}