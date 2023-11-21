package org.example;

import org.example.Controller.Controller;
import org.example.Model.Users;
import org.example.Repository.*;

public class Main {
    public static void main(String[] args) {


        GuideRepository guideRepository = new GuideJSONRepository("src/data/tour.json");
        ToursRepository toursRepository = new ToursJSONRepository("src/data/tour.json");
        UserRepository userRepository = new UserJSONRepository("src/data/user.json");

        Controller controller = new Controller(toursRepository,guideRepository, userRepository);
        controller.login();
    }
}


