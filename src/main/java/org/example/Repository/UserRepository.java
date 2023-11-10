package org.example.Repository;

import org.example.Model.Users;
import org.example.Model.Tours;
import java.util.List;

public interface UserRepository {
    void addUser(Users user);
    void deleteUser(String username);
    String purchaseBooking();
    Users getUser(String username);
    List<Users> getAllUsers();
    List<Tours> getOrderedTours(Users user);

}