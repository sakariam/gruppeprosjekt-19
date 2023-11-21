package org.example.Controller;
import org.example.Model.Guide;
import org.example.Repository.GuideRepository;
import org.example.Repository.ToursRepository;
import org.example.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControllerTest {
    private Controller controller;
    private GuideRepository guideRepositoryMock;
    private ToursRepository toursRepositoryMock;

    private UserRepository userRepositoryMock;

    @BeforeEach
    public void setUp() {
        guideRepositoryMock = mock(GuideRepository.class);
        toursRepositoryMock = mock(ToursRepository.class);
        userRepositoryMock =mock(UserRepository.class);
        controller = new Controller(toursRepositoryMock, guideRepositoryMock,userRepositoryMock);
    }

    @Test
    public void testAdminLogin_AddGuide() {
        String input = "1\n1\nTestDescription\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        when(guideRepositoryMock.getAllGuides()).thenReturn(new ArrayList<>());

        controller.login();

        // Assert the number of guides after adding one
        assertEquals(1, controller.guides.size());
        assertEquals("TestUser", controller.guides.get(0).getName());
    }

    @Test
    public void testGuideLogin_CreateTour() {
        String input = "1\n2\nTestTitle\nTestDescription\n10.0\n5\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ArrayList<Guide> guides = new ArrayList<>();
        guides.add(new Guide("Guide1", "Description1", new ArrayList<>()));
        when(guideRepositoryMock.getAllGuides()).thenReturn(guides);

        controller.login();

        assertEquals(1, guides.get(0).getTourGuides().size());
        assertEquals("TestTitle", guides.get(0).getTourGuides().get(0).getTitle());
    }

}