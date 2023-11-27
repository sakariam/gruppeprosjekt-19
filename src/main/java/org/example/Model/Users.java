package org.example.Model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;


public class Users {
    private String username;
    private String first_name;
    private String last_name;
    private ArrayList<Tours> personalToursList;


    public Users( String username, String first_name, String last_name, ArrayList<Tours> personalToursList) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.personalToursList= personalToursList;
    }

    public Users() {
    }
    public String makeProfile () {

            String profile = "Username: " + username + "\n";
            profile += "first-name: " + first_name + "\n";
            profile += "last-name: " + last_name + "\n";


            return profile;

        }


        public String purchaseBooking () {
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
            } else {
                return "booking is not confirmed. try again";
            }

        }


        public String deleteProfile () {
            Scanner scanner = new Scanner(System.in);
            System.out.print("do you want to delete account:(Y/N) ");
            String userdeletion = scanner.nextLine();

            if (userdeletion.equals("N") || userdeletion.equals("n")) {
                Users users = null;

                return "your account is deleted";


            } else if (userdeletion.equals("Y") || userdeletion.equals("y")) {
                return "thanks, for staying with us";
            }

            return "your answer is confirmed.";

            //scanner.close();

        }


        public String getUsername () {
            return username;
        }

        public void setUsername (String username){
            this.username = username;
        }

        public String getFirst_name () {
            return first_name;
        }

        public void setFirst_name (String first_name){
            this.first_name = first_name;
        }

        public String getLast_name () {
            return last_name;
        }

        public void setLast_name (String last_name){
            this.last_name = last_name;
        }
        public ArrayList<Tours> getPersonalToursList () {
            return personalToursList;
        }

        public void setPersonalToursList (ArrayList < Tours > personalToursList) {
            this.personalToursList = personalToursList;
        }


    @Override
    public String toString() {
        return "Users{"
                + "firstName='" + first_name + '\''
                + ", lastName='" + last_name + '\''
                + ", Username='" + username + '\''
                + ", tours=" + personalToursList
                + '}';
    }

    }





