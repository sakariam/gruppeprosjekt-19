package org.example.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GuideTest {
    private Guide guide;


    @Test
    public void testGettersAndSetters() {
        guide = new Guide("Ole", "Mann, 25 år", new ArrayList<>());

        assertEquals("Ole", guide.getName());
        assertEquals("Mann, 25 år", guide.getDescription());
        assertNotNull(guide.getTourGuides());
        assertEquals(0, guide.getTourGuides().size());

        guide.setName("Ole Normann");
        guide.setDescription("Mann, 26 år");

        ArrayList<Tours> newTourGuides = new ArrayList<>();
        newTourGuides.add(new Tours("Halden", "Tour rundt Haldens kjente steder", 250.0, 10));
        guide.setTourGuides(newTourGuides);

        assertEquals("Ole Normann", guide.getName());
        assertEquals("Mann, 26 år", guide.getDescription());
        assertNotNull(guide.getTourGuides());
        assertEquals(1, guide.getTourGuides().size());
    }
    @Test
    public void testEmptyConstructor() {
        guide = new Guide();

        assertNotNull(guide);
        assertNull(guide.getName());
        assertNull(guide.getDescription());
    }

}