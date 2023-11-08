package org.example.Model;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class ToursTest {
    // TODO: 15.10.2023 Change methodn names so it describes what it is doing. And check both for true and false where you are able to 
    private Tours tour;
    @Test
    void TourIsAvailable() {
        // Arrange
        Tours Tour = new Tours("Fredriksten", "Fredriksten festning", 200, 1);
        // Act
        boolean isAvailable = Tour.getCapacity()>0;
        //Assert
        assertTrue(isAvailable,"The tour is available");
    }
    @Test
    void TourIsNotAvailable() {
        // Arrange
        Tours Tour = new Tours("Fredriksten", "Fredriksten festning", 200, 0);
        // Act
        boolean isAvailable = Tour.getCapacity()>0;
        //Assert
        assertFalse(isAvailable,"The tour is not available");
    }
    @Test
    public void testGettersAndSetters() {
        tour = new Tours("OsloBy", "Guidet tur rundt Oslo", 500, 10);

        assertEquals("OsloBy", tour.getTitle());
        assertEquals("Guidet tur rundt Oslo", tour.getDescription());
        assertEquals(500, tour.getPrice(), 0.001); // Sjekk double med en toleranse på 0.001
        assertEquals(10, tour.getCapacity());

        tour.setTitle("Operahuset");
        tour.setDescription("Tour rundt operahuset");
        tour.setPrice(200.0);
        tour.setCapacity(20);

        assertEquals("Operahuset", tour.getTitle());
        assertEquals("Tour rundt operahuset", tour.getDescription());
        assertEquals(200.0, tour.getPrice(), 0.001);
        assertEquals(20, tour.getCapacity());
    }
    @Test
    public void testEmptyConstructor() {
        tour = new Tours();
        assertNotNull(tour);

        assertEquals(null, tour.getTitle());
        assertEquals(null, tour.getDescription());
        assertEquals(0.0, tour.getPrice());
        assertEquals(0, tour.getCapacity());
    }
    @Test
    public void testToString() {
        tour = new Tours("OsloBy", "Guidet tur rundt Oslo", 500, 10);
        String forventetStreng = "Tour title:OsloBy\nDescription: Guidet tur rundt Oslo\nPrice: 500.0kr";
        String tourString = tour.toString();

        assertEquals(forventetStreng, tourString);
    }

}
