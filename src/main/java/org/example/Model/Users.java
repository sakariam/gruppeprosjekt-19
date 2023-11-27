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





