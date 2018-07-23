package by.itacademy.finalproject.menus.operable.scheduler.scheduled;

import by.itacademy.finalproject.domain.group.Group;

import java.util.Map;
import java.util.Set;

public interface Scheduled<T> {
    Map<String, Set<T>> compose(Set<Group> groups);

    void setSearchingValue();

    String typo();
}
