package org.example.Controller;
import org.example.Model.Guide;
import org.example.Model.Tours;
import org.example.Model.Users;
import org.example.Repository.GuideRepository;
import org.example.Repository.ToursRepository;
import org.example.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private ToursRepository toursRepository;
    private GuideRepository guideRepository;
    private UserRepository userRepository;
    public List<Guide> guides;
    public List<Users> users;

    //Make constructor with all the repository variables
    public Controller(ToursRepository toursRepository, GuideRepository guideRepository, UserRepository userRepository) {
        this.toursRepository = toursRepository;
        this.guideRepository = guideRepository;
        this.userRepository = userRepository;
        this.guides = guideRepository.getAllGuides();
        this.users = userRepository.getAllUsers();
    }


    //Gives user the choice of logging in as Admin,Guide or User
    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***Choose login method***");
        System.out.println("Press <1> for Admin");
        System.out.println("Press <2> for Guide");
        System.out.println("Press <3> for User");
        System.out.println("Press <4> to exit application");

        int loginChoice = scanner.nextInt();

        switch (loginChoice) {
            case 1 -> adminLogin();
            case 2 -> guideLogin();
            case 3 -> userLog_reg();
            case 4 -> {
                System.out.println("Thank you for choosing us, see you next time !");
                scanner.close();
                System.exit(0);
            }
            default -> System.out.println("Input not recognised, please try again");
        }

    }

    //Method that logs into admin
    public void adminLogin() {
        Scanner scanner = new Scanner(System.in);

        //Admin Menu
        System.out.println("***Admin Menu***");
        System.out.println("Press <1> to add a guide");
        System.out.println("Press <2> to remove a guide");
        System.out.println("Press <3> to see list of guides");
        System.out.println("Press <4> to go back to login menu");
        System.out.println("Press <5> to exit application");

        int adminChoice = scanner.nextInt();
        switch (adminChoice) {
            case 1 -> addGuide();

            case 2 -> deleteGuide();

            case 3 -> showAllGuides();

            case 4 -> login();
            case 5 -> {
                System.out.println("See you next time !");
                scanner.close();
                System.exit(0);
            }
            default -> System.out.println("Input not recognised, please try again");
        }
    }

    // Method to add a new guide
    public void addGuide() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the username for the new guide");
        String username = scanner.nextLine();

        System.out.println("Enter the description for the new guide");
        String description = scanner.nextLine();

        Guide newGuide = new Guide(username, description, new ArrayList<>());
        guideRepository.addGuide(newGuide);

        System.out.println("New guide added successfully!");
        adminLogin();
    }

    // Method to delete a guide
    public void deleteGuide() {
        ArrayList<Guide> guides = guideRepository.getAllGuides();
        if (guides.isEmpty()) {
            System.out.println("No guides available.");
            adminLogin();
        }

        System.out.println("Available Guides:");
        for (int i = 0; i < guides.size(); i++) {
            System.out.println((i + 1) + ". " + guides.get(i).getName());
        }

        System.out.println("Enter the number of the guide to delete (0 to cancel):");
        int choice = getUserChoice(guides.size());

        if (choice > 0) {
            guideRepository.delGuide(choice - 1);
            System.out.println("Guide and their tours deleted.");
            adminLogin();
        } else {
            System.out.println("Operation canceled.");
            adminLogin();
        }
    }

    // Method to display a list of all guides and their tours
    public void showAllGuides() {
        ArrayList<Guide> allGuides = guideRepository.getAllGuides();

        if (allGuides.isEmpty()) {
            System.out.println("No guides available.\n");
        } else {
            System.out.println("List of Guides:");
            for (Guide guide : allGuides) {
                System.out.println("Guide name: " + guide.getName());
                System.out.println("Description: " + guide.getDescription());
                System.out.println("\nTours:\n");
                for (Tours tour : guide.getTourGuides()) {
                    System.out.println("Tour title: " + tour.getTitle());
                    System.out.println("Description: " + tour.getDescription());
                    System.out.println("Price: " + tour.getPrice());
                    System.out.println("Capacity: " + tour.getCapacity() + "\n");
                }
            }
        }
        System.out.println("\nPress <1> to go back");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("1")) {
                adminLogin();
                break;
            }

        }
        scanner.close();
    }

    //Method that makes user choose which guide to log in as
    public void guideLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***Guide Menu***");
        if (guides.isEmpty()) {
            System.out.println("No guides available\n");
            login();
        } else {
            System.out.println("Select a guide to log in:");
            for (int i = 0; i < guides.size(); i++) {
                System.out.println((i + 1) + ". " + guides.get(i).getName());
            }
            System.out.println("Press <0> to go back to the main menu");
            System.out.println("Press <5> to exit application");

            int guideChoice = scanner.nextInt();

            if (guideChoice == 0) {
                login();
            } else if (guideChoice >= 1 && guideChoice <= guides.size()) {
                Guide selectedGuide = guides.get(guideChoice - 1);
                guideMenu(selectedGuide);
            } else if (guideChoice == 5) {
                System.out.println("See you next time!");
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("Invalid choice. Please try again.");
                guideLogin();
            }
        }
    }

    // Method that lets user choose to add, remove or display tour
    public void guideMenu(Guide guide) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***Guide Menu for " + guide.getName() + "***");
        System.out.println("Press <1> to add a tour");
        System.out.println("Press <2> to display all tours");
        System.out.println("Press <3> to remove a tour");
        System.out.println("Press <4> to go back to login menu");
        System.out.println("Press <5> to exit application");

        int guideLogin = scanner.nextInt();
        switch (guideLogin) {
            case 1 -> createTour(guide);

            case 2 -> displayTours(guide);

            case 3 -> delTour(guide);

            case 4 -> login();
            case 5 -> {
                System.out.println("Thank you for choosing us, see you next time !");
                scanner.close();
                System.exit(0);
            }
            default -> System.out.println("Input not recognised, please try again");


        }
    }

    //Creates a tour and puts it in json
    public void createTour(Guide guide) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Creating a new Tour");

        //Get all the variables for making a tour
        System.out.println("Enter the name/title of your tour");
        String name = scanner.nextLine();

        System.out.println("Enter the description");
        String description = scanner.nextLine();

        System.out.println("Enter the price");
        double price = scanner.nextDouble();

        System.out.println("Enter how many people can join");
        int capacity = scanner.nextInt();

        Tours newTour = new Tours(name, description, price, capacity);

        guide.getTourGuides().add(newTour);
        toursRepository.addTour(newTour);

        guideRepository.updateGuide(guide);

        System.out.println("Success!");
        guideMenu(guide);


    }

    //Shows a list of all the tours of the current guide
    public void displayTours(Guide guide) {
        ArrayList<Tours> allTours = guide.getTourGuides();

        if (allTours.isEmpty()) {
            System.out.println("No tours available.\n");
        } else {
            System.out.println("List of Tours:");
            for (Tours tour : allTours) {
                System.out.println("Title: " + tour.getTitle());
                System.out.println("Description: " + tour.getDescription());
                System.out.println("Price: " + tour.getPrice());
                System.out.println("Capacity: " + tour.getCapacity());
                System.out.println();
            }
        }
        System.out.println("Press <1> to go back");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("1")) {
                guideMenu(guide);
                break;
            }

        }
        scanner.close();
    }

    //Gives guide a choice to delete a tour
    public void delTour(Guide guide) {
        ArrayList<Tours> tours = guide.getTourGuides();
        if (tours.isEmpty()) {
            System.out.println("No tours available.");
            guideMenu(guide);
        }

        System.out.println("Available Tours:");
        for (int i = 0; i < tours.size(); i++) {
            System.out.println((i + 1) + ". " + tours.get(i).getTitle());
        }

        System.out.println("Enter the number of the tour to delete (0 to cancel):");
        int choice = getUserChoice(tours.size());

        if (choice > 0) {
            toursRepository.delTour(choice - 1);
            System.out.println("Tour deleted.");
            guideMenu(guide);
        } else {
            System.out.println("Operation canceled.");
            guideMenu(guide);
        }
    }

    //Gets user input to see if it is valid
    private int getUserChoice(int max) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > max) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return choice;
    }


    // Method for creating and logging into a specific user
    public void userLog_reg() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***User Menu***");
        System.out.println("Press <1> to make profile ");
        System.out.println("Press <2> to to choose profile ");
        System.out.println("Press <3> to go back to login");
        System.out.println("Press <4> to exit program");


        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1 -> createProfile();
            case 2 -> userLogin();
            case 3 -> login();
            case 4 -> {
                System.out.println("See you next time !");
                scanner.close();
                System.exit(0);
            }
            default -> System.out.println("Input not recognised, please try again");
        }
    }

    //Asks user for relevant info to create a profile
    public void createProfile() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the username for the new user");
        String username = scanner.nextLine();

        System.out.println("Enter the first name for the new user");
        String first_name = scanner.nextLine();

        System.out.println("Enter the last name name for the new user");
        String last_name = scanner.nextLine();


        Users newUsers = new Users(username, first_name, last_name, new ArrayList<>());
        userRepository.addUser(newUsers);

        System.out.println("New User added successfully!");
        userLog_reg();
    }


    //Gets a list of users you can log in as
    public void userLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***User Menu***");
        if (users.isEmpty()) {
            System.out.println("No users available\n");
            login();
        } else {
            System.out.println("Select a user to log in:");
            for (int i = 0; i < users.size(); i++) {
                System.out.println((i + 1) + ". " + users.get(i).getUsername());
            }
            System.out.println("Press <0> to go back to the main menu");
            System.out.println("Press <5> to exit application");

            int userChoice = scanner.nextInt();

            if (userChoice == 0) {
                login();
            } else if (userChoice >= 1 && userChoice <= users.size()) {
                Users selectedUser = users.get(userChoice - 1);
                userMenu(selectedUser);
            } else if (userChoice == 5) {
                System.out.println("See you next time!");
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("Invalid choice. Please try again.");
                userLogin();
            }
        }
    }

    //Menu for users after they log in
    // TODO: 08.11.2023 Inne i userMenu må du la bruker velge mellom, bestille turer, se turer, slette konto, se beløpet sitt og legge til penger. Alle skal ha sin egen funksjon
    public void userMenu(Users users) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***User Menu***");
        System.out.println("Press <1> to order a tour");
        System.out.println("Press <2> to see a list of purchased tours");
        System.out.println("Press <3> to delete account");
        System.out.println("Press <4> to change user account");
        System.out.println("Press <5> to go back to login menu");
        System.out.println("Press <6> to go exit program");

        //System.out.println("Press <3> to see your balance");
        //System.out.println("Press <4> to add balance");
        int userChoice = scanner.nextInt();
        switch (userChoice) {

            case 1 -> {
                orderTour(users);
            }
            case 2 -> {
                displayTourOrders(users);
            }
            case 3 -> {
                delUser(users);
            }
            case 4 -> userLogin();
            case 5 -> login();
            case 6 -> {

                System.out.println("Thank you for choosing us, see you next time !");
                scanner.close();
                System.exit(0);
            }
            default -> System.out.println("Input not recognised, please try again");
        }
    }

    public void orderTour(Users user) {
        Scanner scanner = new Scanner(System.in);

        // Get the available tours for the user to choose from
        List<Tours> allTours = toursRepository.getAllTours();

        if (allTours.isEmpty()) {
            System.out.println("No tours available.\n");
            userMenu(user);
        } else {
            System.out.println("Select a tour to order:");
            for (int i = 0; i < allTours.size(); i++) {
                System.out.println((i + 1) + ". " + allTours.get(i).getTitle());
            }

            int tourChoice = getUserChoice(allTours.size());

            if (tourChoice >= 1 && tourChoice <= allTours.size()) {
                Tours selectedTour = allTours.get(tourChoice - 1);
                user.getPersonalToursList().add(selectedTour);
                userRepository.updateUser(user);

                System.out.println("Tour ordered successfully!");
                userMenu(user);
            } else {
                System.out.println("Invalid choice. Please try again.");

                orderTour(user);
            }


        }

    }

    // Method to display all ordered tours for a user
    public void displayTourOrders(Users user) {
        List<Tours> orderedTours = user.getPersonalToursList();

        if (orderedTours.isEmpty()) {
            System.out.println("No tours ordered.\n");
        } else {
            System.out.println("List of Ordered Tours:");
            for (Tours tour : orderedTours) {
                System.out.println("Title: " + tour.getTitle());
                System.out.println("Description: " + tour.getDescription());
                System.out.println("Price: " + tour.getPrice());
                System.out.println("Capacity: " + tour.getCapacity());
                System.out.println();
            }
        }

        System.out.println("Press <1> to go back");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("1")) {
                userMenu(user);
                break;
            }
        }
        scanner.close();
    }

    // Method to delete a user
    public void delUser(Users user) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username to confirm deletion:");
        String enteredUsername = scanner.nextLine();

        if (enteredUsername.equals(user.getUsername())) {
            System.out.println("Are you sure you want to delete your account? (yes/no)");
            String confirmation = scanner.nextLine().toLowerCase();

            if (confirmation.equals("yes")) {
                userRepository.deleteUser(user.getUsername());
                System.out.println("User deleted.");
                // Perform any additional actions if needed
            } else {
                System.out.println("Entered username does not match your account. Operation canceled.");
                // Handle the situation where the entered username doesn't match the logged-in user
            }

            // Proceed with the appropriate action (e.g., go back to the menu)
            userLogin();
        }
    }

}



