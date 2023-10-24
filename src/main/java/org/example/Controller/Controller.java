package org.example.Controller;
import org.example.Model.Tours;
import org.example.Repository.ToursRepository;

import java.util.Scanner;

public class Controller {
    //Make repository variables. eks. private GuideRepository guideRepository
    private ToursRepository toursRepository;

    //Make constructor with all the repository variables
    public Controller(ToursRepository toursRepository){
        this.toursRepository = toursRepository;
    }

    public Controller() {

    }

    //Gives user the choice of logging in with Admin,Guide or User
    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***Choose login method***");
        System.out.println("Press <1> for Admin");
        System.out.println("Press <2> for Guide");
        System.out.println("Press <3> for User");
        System.out.println("Press <4> to exit applicatin");

        int loginChoice = scanner.nextInt();

        switch (loginChoice) {
            case 1 -> adminLogin();
            case 2 -> guideLogin();
            case 3 -> userLogin();
            case 4 -> {
                System.out.println("Thank you for choosing us, see you next time !");
                scanner.close();
                System.exit(0);
            }
            default -> System.out.println("Input not recognised, please try again");
        }

    }

    public void adminLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***Admin Menu***");
        System.out.println("Press <1> to add a guide");
        System.out.println("Press <2> to remove a guide");
        System.out.println("Press <3> to see list of guides");
        System.out.println("Press <4> to go back to login menu");
        System.out.println("Press <5> to exit application");

        int adminChoice = scanner.nextInt();
        switch (adminChoice) {
            case 1 -> {//addGuide();
            }
            case 2 -> {//removeGuide();
            }
            case 3 -> {//guideList();
            }
            case 4 -> login();
            case 5 -> {
                System.out.println("Thank you for choosing us, see you next time !");
                scanner.close();
                System.exit(0);
            }
            default -> System.out.println("Input not recognised, please try again");
        }
    }

    public void guideLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***Guide Menu***");
        System.out.println("Press <1> to add a tour");
        System.out.println("Press <2> to remove a tour");
        System.out.println("Press <3> to list of your tours");
        System.out.println("Press <4> to go back to login menu");
        System.out.println("Press <5> to exit application");

        int guideLogin = scanner.nextInt();
        switch (guideLogin) {
            case 1 -> {createTour();
            }
            case 2 -> {//removeTour();
            }
            case 3 -> {//tourList();
            }
            case 4 -> login();
            case 5 -> {
                System.out.println("Thank you for choosing us, see you next time !");
                scanner.close();
                System.exit(0);
            }
            default -> System.out.println("Input not recognised, please try again");
        }
    }
    public void createTour(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Creating a new Tour");

        //Get all the variables for making a tour
        System.out.println("Enter the name/title of your tour");
        String name = scanner.nextLine();

        System.out.println("Enter the description");
        String description = scanner.nextLine();

        System.out.println("Enter the price");
        Double price = scanner.nextDouble();

        System.out.println("Enter how many people can join");
        int capacity = scanner.nextInt();

        Tours newTour = new Tours(name,description,price,capacity);

        toursRepository.addTour(newTour);

        System.out.println("Success!");
        guideLogin();


    }

    public void userLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***User Menu***");
        System.out.println("Press <1> to Tours available");
        System.out.println("Press <2> to remove a tour");
        System.out.println("Press <3> to see balance");
        System.out.println("Press <4> to go back to login menu");
        System.out.println("Press <5> to exit application");

        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1 -> {//addTour();
            }
            case 2 -> {//removeTour();
            }
            case 3 -> {//tourList();
            }
            case 4 -> login();
            case 5 -> {
                System.out.println("Thank you for choosing us, see you next time !");
                scanner.close();
                System.exit(0);
            }
            default -> System.out.println("Input not recognised, please try again");
        }
    }
}


