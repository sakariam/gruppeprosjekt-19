package org.example;

import org.example.Controller.Controller;
import org.example.Repository.*;

public class Main {
    public static void main(String[] args) {

        // TODO: 17.10.2023 Under sender vi json filene til repository
        GuideRepository guideRepository = new GuideJSONRepository("src/data/tour.json");
        ToursRepository toursRepository = new ToursJSONRepository("src/data/tour.json");
        UserRepository userRepository = new UserJSONRepository("src/data/user.json");
        // TODO: 17.10.2023 Add the repositories inside the parenthesis in Controller();
        Controller controller = new Controller(toursRepository,guideRepository, userRepository);

        controller.login();
    }
}