package org.example.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class ToursTest {
    // TODO: 15.10.2023 Change methodn names so it describes what it is doing. And check both for true and false where you are able to 
    @Test
    void TourIsAvailable() {
        // Arrange
        Tours Tour = new Tours("Fredriksten", "Fredriksten festning", 200, 15);
        // Act
        boolean isAvailable = Tour.getCapacity()>0;
        //Assert
        assertTrue(isAvailable,"The tour is available");
    }

    @Test
    void userBookTour() {
    }

    @Test
    void userCancelTour() {
    }

    @Test
    void getAvailableSpots() {
    }

    @Test
    void getTourDetails() {
    }

    @Test
    void getTourRevenue() {
    }
}
