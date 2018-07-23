package by.itacademy.finalproject.menus.serializing.serialization;

import by.itacademy.finalproject.domain.School;

public interface SchoolSerialization {
    School getSchool();

    String getSource();

    void serialize();

    String typo();
}
