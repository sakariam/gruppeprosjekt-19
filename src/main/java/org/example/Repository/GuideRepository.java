package org.example.Repository;

import org.example.Model.Guide;

import java.util.ArrayList;

public interface GuideRepository {
    void addGuide(Guide guide);

    void delGuide(int index);

    ArrayList<Guide> getAllGuides();

    void updateGuide(Guide guide);
}
