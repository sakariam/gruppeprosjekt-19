/*package org.example.Repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GuideJSONRepositoryIOExceptionTest {
        @Test
        public void testReadJsonFileIOException() {
            String testFilename = "nofile_file.json";

            GuideJSONRepository guideRepository = new GuideJSONRepository(testFilename);

            assertThrows(IOException.class, () -> {
                guideRepository.readJsonFile(testFilename);
            });
        }

        @Test
        public void testWriteToJsonIOException() {
            String testFilename = "not_a_file.json";

            GuideJSONRepository guideRepository = new GuideJSONRepository(testFilename);

            // Test skriving til en ugyldig filsti, noe som skal kaste IOException
            assertThrows(IOException.class, () -> {
                guideRepository.writeToJson(testFilename, null); // Her kan du sende en liste med guider om nødvendig
            });
        }
    }*/