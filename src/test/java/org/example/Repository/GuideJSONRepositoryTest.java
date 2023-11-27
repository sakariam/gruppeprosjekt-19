package org.example.Repository;

import static org.junit.jupiter.api.Assertions.*;


import org.example.Model.Guide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GuideJSONRepositoryTest {

        private GuideJSONRepository guideRepository;
        private final String testFilename = "src/data/test_guides.json";

        @BeforeEach
        public void setUp() {
            guideRepository = new GuideJSONRepository(testFilename);
        }

        @Test
        public void testAddGuide() {
            Guide testGuide = new Guide("Test Guide", "Description", new ArrayList<>());

            guideRepository.addGuide(testGuide);

            ArrayList<Guide> guides = guideRepository.getAllGuides();
            assertTrue(guides.contains(testGuide));
        }

        @Test
        public void testDeleteGuide() {
            Guide testGuide = new Guide("Test Guide", "Description", new ArrayList<>());

            guideRepository.addGuide(testGuide);
            ArrayList<Guide> guidesBeforeDeletion = new ArrayList<>(guideRepository.getAllGuides());

            // Assuming guides list is not empty
            int initialSize = guidesBeforeDeletion.size();

            if (initialSize > 0) {
                guideRepository.delGuide(0);

                ArrayList<Guide> guidesAfterDeletion = new ArrayList<>(guideRepository.getAllGuides());
                int newSize = guidesAfterDeletion.size();

                assertEquals(initialSize - 1, newSize);

                assertFalse(guidesAfterDeletion.contains(guidesBeforeDeletion.get(0)));
            } else {
                fail("Test failed: The guides list is empty. Ensure the list contains guides before testing deletion.");
            }
        }
        @Test
        public void testUpdateGuide() {
            Guide testGuide = new Guide("Test Guide", "Description", new ArrayList<>());

            guideRepository.addGuide(testGuide);

            ArrayList<Guide> guides = guideRepository.getAllGuides();
            Guide guideToUpdate = guides.get(0);

            guideToUpdate.setDescription("Updated description");

            guideRepository.updateGuide(guideToUpdate);

            Guide updatedGuide = guideRepository.getAllGuides().get(0);

            assertEquals("Updated description", updatedGuide.getDescription());
        }

        @Test
        public void testReadJsonFile() {
            List<Guide> existingGuides = guideRepository.readJsonFile(testFilename);

            assertNotNull(existingGuides);
            assertFalse(existingGuides.isEmpty());
        }

        @Test
        public void testWriteToJson() {
            ArrayList<Guide> guides = guideRepository.getAllGuides();

            GuideJSONRepository.writeToJson(testFilename, guides);

            File file = new File(testFilename);
            assertTrue(file.exists());
        }
}