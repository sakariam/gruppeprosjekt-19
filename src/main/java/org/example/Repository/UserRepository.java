package org.example.Repository;

import org.example.Model.Users;
import org.example.Model.Tours;
import java.util.List;

public interface UserRepository {
    void addUser(Users user);
    void deleteUser(String username);
    String purchaseBooking();  // this is our first try at making purchasing booking
                               // it is a different method to order tour in controller
    Users getUser(String username);
    List<Users> getAllUsers();
    List<Tours> getOrderedTours(Users user);

    void updateUser(Users user);
}