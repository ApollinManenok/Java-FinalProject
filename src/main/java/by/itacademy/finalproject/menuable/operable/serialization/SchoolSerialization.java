package by.itacademy.finalproject.menuable.operable.serialization;

import by.itacademy.finalproject.domain.School;

public interface SchoolSerialization {
    School getSchool();

    String getSource();

    void serialize();

    String typo();
}
