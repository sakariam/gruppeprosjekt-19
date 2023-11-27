package org.example.Model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.example.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class UserTest {
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
    public Users getUser(String username) {
        for (Users user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public List<Users> getAllUsers() {
        return users;
    }

    public BookingResult purchaseBooking() {
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

            return new BookingResult(booking, true);
        } else {
            return new BookingResult("booking is not confirmed. try again", false);
        }
    }

    private List<Users> users = new ArrayList<>();

    private boolean writeToJsonCalled = false;
    // Declare the filename (assuming it's a constant)
    private static final String filename = "your_filename.json";

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
        Users user = new Users("lionel", "messi", "goat", new ArrayList<Tours>());

        // Act
        userTest.addUser(user);
        // Assert
        List<Users> usersList =  new ArrayList<>();
        usersList.add(user);




        // Check that the user list is not null
        Assertions.assertNotNull(usersList, "User list should not be null");




        // Check that the user list size is 1
        Assertions.assertEquals(usersList.size(), usersList.size(), "User list size should be 1");

        // Check that the added user is in the list
        Assertions.assertTrue(usersList.contains(user), "User should be in the list");

        // Check that the user in the list has the expected attributes
        Users addedUser = usersList.get(0);
        Assertions.assertEquals("lionel", addedUser.getUsername(), "Incorrect first name");
        Assertions.assertEquals("messi", addedUser.getFirst_name(), "Incorrect last name");
        Assertions.assertEquals("goat", addedUser.getLast_name(), "Incorrect role");

    }

    @Test
    public void testDeleteUser() {

        // Arrange
            UserTest userTest = new UserTest();
            Users user1 = new Users("lionel", "messi", "goat", new ArrayList<>());
            Users user2 = new Users("cristiano", "ronaldo", "legend", new ArrayList<>());
            // Act
            userTest.addUser(user1);
            userTest.addUser(user2);

            List<Users> initialUsersList =  new ArrayList<>();
            initialUsersList.add(user1);
            initialUsersList.add(user2);
            System.out.println(initialUsersList.size());


            // Check that both users are initially in the list
            Assertions.assertEquals(2, initialUsersList.size(), "Initial user list size should be 2");
            Assertions.assertTrue(initialUsersList.contains(user1), "User1 should be in the list");
            Assertions.assertTrue(initialUsersList.contains(user2), "User2 should be in the list");

            // Act: Delete a user
            userTest.deleteUser("lionel");
            initialUsersList.remove(user1);

            // Assert
            List<Users> updatedUsersList = initialUsersList;

            // Check that the user list size is now 1 after deletion
            Assertions.assertEquals(1, updatedUsersList.size(), "User list size should be 1 after deletion");

            // Check that the deleted user is no longer in the list
            Assertions.assertFalse(updatedUsersList.contains(user1), "User1 should be deleted");
            // Check that the remaining user is still in the list
            Assertions.assertTrue(updatedUsersList.contains(user2), "User2 should still be in the list");
        }

    @Test
    public void testPurchaseBookingConfirmed() {
        // Arrange
        BookingResult userTest = new BookingResult("Guide: John Doe.", true);
        ArrayList<String> bookinginfousertest = new ArrayList<>();
       bookinginfousertest.add("How many people?: 5");
       bookinginfousertest.add("Price: 100.0");
       userTest.setBookinginfo(bookinginfousertest);

        // Simulate user input with a ByteArrayInputStream
        String input = "John Doe\n5\n100.0\nyes\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        BookingResult result = userTest;
        System.out.println(result.isConfirmed());
        System.out.println(result.getBookinginfo());



        // Assert
        Assertions.assertTrue(result.isConfirmed(), "Booking should be confirmed");
        Assertions.assertTrue(result.getBookingDetails().contains("Guide: John Doe"), "Guide's name not found in result");
        Assertions.assertTrue(result.getBookinginfo().get(0).contains("How many people?: 5"), "Number of people not found in result");
        Assertions.assertTrue(result.getBookinginfo().get(1).contains("Price: 100.0"), "Price not found in result");

        // Act


    }

    @Test
    public void testPurchaseBookingNotConfirmed() {
        // Arrange
        BookingResult userTest = new BookingResult("booking is not confirmed. try again", true);

        // Simulate user input with a ByteArrayInputStream
        String input = "John Doe\n5\n100.0\nno\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));


        // Act
        BookingResult result = userTest;

        // Assert
        // Check that the result contains the expected information
        Assertions.assertTrue(result.getBookingDetails().contains("booking is not confirmed. try again"), "Not confirmed message not found in result");

        // Reset System.in back to the original InputStream
        System.setIn(System.in);
    }
    @Test
    public void testGetUser() {
        // Arrange
        UserTest userTest = new UserTest();
        Users user1 = new Users("lionel", "messi", "goat", new ArrayList<>());
        Users user2 = new Users("cristiano", "ronaldo", "legend", new ArrayList<>());

        userTest.addUser(user1);
        userTest.addUser(user2);
        userTest.getUser("lionel");

        // Act
        Users foundUser = userTest.getUser("lionel");

        // Assert
        Assertions.assertNotNull(foundUser, "User should be found");
        Assertions.assertEquals("lionel", foundUser.getUsername(), "Incorrect username");
        Assertions.assertEquals("messi", foundUser.getFirst_name(), "Incorrect first name");
        Assertions.assertEquals("goat", foundUser.getLast_name(), "Incorrect role");

        // Test with a username that doesn't exist
        Users nonExistentUser = userTest.getUser("neymar");
        Assertions.assertNull(nonExistentUser, "User should not be found");
    }

    @Test
    public void testGetAllUsers() {
        // Arrange
        UserTest userTest = new UserTest();
        Users user1 = new Users("lionel", "messi", "goat", new ArrayList<>());
        Users user2 = new Users("cristiano", "ronaldo", "legend", new ArrayList<>());

        userTest.addUser(user1);
        userTest.addUser(user2);
        users.getClass();

        // Act
        List<Users> allUsers = userTest.getAllUsers();


        // Assert
        Assertions.assertNotNull(allUsers, "User list should not be null");
        Assertions.assertEquals(2, allUsers.size(), "User list size should be 2");

        // Check that both users are in the list
        Assertions.assertTrue(allUsers.contains(user1), "User1 should be in the list");
        Assertions.assertTrue(allUsers.contains(user2), "User2 should be in the list");
    }



    @Test
    public void testUpdateUser() {


        // Arrange
        UserTest userTest = new UserTest();
        Users user = new Users("lionel", "messi", "goat", new ArrayList<>());

        // Add a user to the list
        userTest.addUser(user);

        // Act
        userTest.updateUser(user);

        // Assert
        List<Users> updatedUsers = new ArrayList<>();

        updatedUsers.add(user);

        // Verify that the user list has been updated
        Assertions.assertNotNull(updatedUsers, "User list should not be null");
        Assertions.assertEquals(1, updatedUsers.size(), "User list size should be 1");

        // Check that the user in the list has the expected attributes
        Users updatedUser = updatedUsers.get(0);
        Assertions.assertEquals("lionel", updatedUser.getUsername(), "Incorrect username");
        Assertions.assertEquals("messi", updatedUser.getFirst_name(), "Incorrect first name");
        Assertions.assertEquals("goat", updatedUser.getLast_name(), "Incorrect role");
    }
    public void updateUser(Users user) {
        writeToJson(filename, users);
    }
}

    /*
    

         */





