package org.example.Model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class UserTest {
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
        Users user = new Users("lionel", "messi", "goat", new ArrayList<>());

        // Act
        userTest.addUser(user);

        // Assert
        List<Users> usersList = userTest.getUsers();

        // Check that the user list is not null
        assertNotNull(usersList, "User list should not be null");

        // Check that the user list size is 1
        assertEquals(1, usersList.size(), "User list size should be 1");

        // Check that the added user is in the list
        assertTrue(usersList.contains(user), "User should be in the list");

        // Check that the user in the list has the expected attributes
        Users addedUser = usersList.get(0);
        assertEquals("lionel", addedUser.getUsername(), "Incorrect first name");
        assertEquals("messi", addedUser.getFirst_name(), "Incorrect last name");
        assertEquals("goat", addedUser.getLast_name(), "Incorrect role");

    }

    @Test
    public void deleteUser(String username) {

            // Arrange
            UserTest userTest = new UserTest();
            Users user1 = new Users("lionel", "messi", "goat", new ArrayList<>());
            Users user2 = new Users("cristiano", "ronaldo", "legend", new ArrayList<>());

            // Act
            userTest.addUser(user1);
            userTest.addUser(user2);

            // Check that both users are initially in the list
            List<Users> initialUsersList = userTest.getUsers();
            assertEquals(2, initialUsersList.size(), "Initial user list size should be 2");
            assertTrue(initialUsersList.contains(user1), "User1 should be in the list");
            assertTrue(initialUsersList.contains(user2), "User2 should be in the list");

            // Act: Delete a user
            userTest.deleteUser("lionel");

            // Assert
            List<Users> updatedUsersList = userTest.getUsers();

            // Check that the user list size is now 1 after deletion
            assertEquals(1, updatedUsersList.size(), "User list size should be 1 after deletion");

            // Check that the deleted user is no longer in the list
            assertFalse(updatedUsersList.contains(user1), "User1 should be deleted");
            // Check that the remaining user is still in the list
            assertTrue(updatedUsersList.contains(user2), "User2 should still be in the list");
        }

    @Test
    public void testPurchaseBookingConfirmed() {
        // Arrange
        UserTest userTest = new UserTest();

        // Simulate user input with a ByteArrayInputStream
        String input = "John Doe\n5\n100.0\nyes\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        BookingResult result = userTest.purchaseBooking();

        // Assert
        assertTrue(result.isConfirmed(), "Booking should be confirmed");
        assertTrue(result.getBookingDetails().contains("Guide: John Doe"), "Guide's name not found in result");
        assertTrue(result.getBookingDetails().contains("How many people?: 5"), "Number of people not found in result");
        assertTrue(result.getBookingDetails().contains("Price: 100.0"), "Price not found in result");


        // Act
    }

    @Test
    public void testPurchaseBookingNotConfirmed() {
        // Arrange
        UserTest userTest = new UserTest();

        // Simulate user input with a ByteArrayInputStream
        String input = "John Doe\n5\n100.0\nno\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Act
        BookingResult result = userTest.purchaseBooking();

        // Assert
        // Check that the result contains the expected information
        assertTrue(result.getBookingDetails().contains("booking is not confirmed. try again"), "Not confirmed message not found in result");

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
        assertNotNull(foundUser, "User should be found");
        assertEquals("lionel", foundUser.getUsername(), "Incorrect username");
        assertEquals("messi", foundUser.getFirst_name(), "Incorrect first name");
        assertEquals("goat", foundUser.getLast_name(), "Incorrect role");

        // Test with a username that doesn't exist
        Users nonExistentUser = userTest.getUser("neymar");
        assertNull(nonExistentUser, "User should not be found");
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
        assertNotNull(allUsers, "User list should not be null");
        assertEquals(2, allUsers.size(), "User list size should be 2");

        // Check that both users are in the list
        assertTrue(allUsers.contains(user1), "User1 should be in the list");
        assertTrue(allUsers.contains(user2), "User2 should be in the list");
    }

    @Test
    public void testGetOrderedTours() {
        // Arrange
        UserTest userTest = new UserTest();
        Users user = new Users("lionel", "messi", "goat", new ArrayList<>());

        // Act
        List<Tours> orderedTours = userTest.getOrderedTours(user);

        // Assert
        assertNotNull(orderedTours, "Ordered tours list should not be null");

        // Assuming some logic in getOrderedTours method that orders tours for a user
        // Add assertions based on the actual behavior of your getOrderedTours method

        // For example, if the method returns an empty list by default
        assertTrue(orderedTours.isEmpty(), "Ordered tours list should be empty");
    }

    public List<Tours> getOrderedTours(Users user) {
        return getOrderedTours(user);
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
        List<Users> updatedUsers = userTest.getUsers();

        // Verify that the user list has been updated
        assertNotNull(updatedUsers, "User list should not be null");
        assertEquals(1, updatedUsers.size(), "User list size should be 1");

        // Check that the user in the list has the expected attributes
        Users updatedUser = updatedUsers.get(0);
        assertEquals("lionel", updatedUser.getUsername(), "Incorrect username");
        assertEquals("messi", updatedUser.getFirst_name(), "Incorrect first name");
        assertEquals("goat", updatedUser.getLast_name(), "Incorrect role");
    }
    public void updateUser(Users user) {
        writeToJson(filename, users);
    }
}

    /*
    

         */





