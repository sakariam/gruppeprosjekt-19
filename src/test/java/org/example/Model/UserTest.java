package org.example.Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Model.Users;
import org.example.Repository.UserRepository;
import java.util.ArrayList; // Import the ArrayList class
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class UserTest {
    private List<Users> users = new ArrayList<>();

    private boolean writeToJsonCalled = false;
    // Declare the filename (assuming it's a constant)
    private static final String filename = "your_filename.json";

    // Declare the ObjectMapper (assuming it's a constant)
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public void addUser(Users user) {
        // Adds a User object to the users list
        // For simplicity, assuming users is a class member
        users.add(user);
        // Writes the updated user list to the JSON file
        writeToJson("filename", users);
    }

    // Simulate the behavior of writeToJson without actually writing to a file
    private void writeToJson(String filename, List<Users> users) {
        writeToJsonCalled = true;
    }

    // Assuming you have a method to get users
    private List<Users> getUsers() {
        // Implement the method to return the users list
        return new ArrayList<>();
    }

    @Test
    public void testAddUser() {
        // Arrange
        UserTest userTest = new UserTest();
        // Create a sample user
        Users user = new Users("sakaria", "abidi", "dd", new ArrayList<>());

        // Act
        userTest.addUser(user);

        // Assert
        List<Users> usersList = userTest.getUsers(); // Assuming you have a method to get users
        assertEquals(1, usersList.size());
        assertEquals(user, usersList.get(0));

        // Check the flag to see if writeToJson was called
        assertTrue(writeToJsonCalled);
    }


    }
    /*
    void deleteUser(String username);
    String purchaseBooking();
    Users getUser(String username);
    List<Users> getAllUsers();
    List<Tours> getOrderedTours(Users user);

    void updateUser(Users user);

         */





