package by.itacademy.finalproject.menus.operable.search.searchable;

import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.Student;

import java.util.Set;

public interface Searchable {
    Set<Student> search(Set<Group> groups);

    String typo();

    void setSearchingValue();
}
