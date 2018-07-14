package by.itacademy.finalproject.menuable.operable.sort.scheduled;

import by.itacademy.finalproject.domain.Group;

import java.util.Set;

public interface Scheduled {
    void scheduled(Set<Group> groups);

    String typo();
}
