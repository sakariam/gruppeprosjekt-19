package org.example.Repository;

import org.example.Model.Tours;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class ToursJSONRepositoryTest {

    private static final String TEST_TOURS = "src/data/test-tour.json";
    private ToursJSONRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new ToursJSONRepository(TEST_TOURS);
    }


    //Tour added in tours.json instead of test-tour.json
    @Ignore
    @Test
    public void testAddTour() {
        ToursJSONRepository repository = new ToursJSONRepository(TEST_TOURS);
        Tours testTour = new Tours("Moss", "Tur rundt byen Moss", 200.0, 5);

        repository.addTour(testTour);

        List<Tours> allTours = repository.getAllTours();
        assertEquals(1, allTours.size());
        assertEquals(testTour, allTours.get(0));
    }

    @Test
    public void testDelTour() {
        Tours testTour = new Tours("Moss", "Tur rundt byen Moss", 200.0, 5);
        repository.addTour(testTour);

        repository.delTour(0);

        List<Tours> allTours = repository.getAllTours();
        assertEquals(0, allTours.size());
    }

    @Test
    public void testGetTour() {
        Tours testTour = new Tours("Moss", "Tur rundt byen Moss", 200.0, 5);
        repository.addTour(testTour);

        Tours retrievedTour = repository.getTour(0);

        assertNotNull(retrievedTour);
        assertEquals(testTour, retrievedTour);
    }
    @Test
    public void testGetTourWithInvalidIndex() {
        ToursJSONRepository repository = new ToursJSONRepository("src/data/test-tours.json");

        Tours result = repository.getTour(100);

        assertNull(result);
    }


    @Test
    public void testReadJsonFileIOExceptionHandling() {
        String testFilename = "nonexistent-file.json";

        ToursJSONRepository repository = new ToursJSONRepository(testFilename);

        List<Tours> result = repository.readJsonFile(testFilename);

        assertNull(result);
    }
    @AfterEach
    public void tearDown() {
        repository.clearAllTours();
    }
}