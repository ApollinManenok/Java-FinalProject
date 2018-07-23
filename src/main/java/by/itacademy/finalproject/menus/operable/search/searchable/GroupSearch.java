package by.itacademy.finalproject.menus.operable.search.searchable;

import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.domain.group.StudentNameComparator;
import by.itacademy.finalproject.inputable.StringInput;

import java.util.Set;
import java.util.TreeSet;

public class GroupSearch implements Searchable {
    private StringInput stringInput = new StringInput();
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Set<Student> search(Set<Group> groups) {
        Set<Student> students = new TreeSet<>(new StudentNameComparator());
        for (Group group : groups) {
            checkedFill(group, students);
        }
        return students;
    }

    private void checkedFill(Group group, Set<Student> students) {
        if (group.getName().equalsIgnoreCase(name)) students.addAll(group.getStudents());
    }

    @Override
    public String typo() {
        return "Search by group name";
    }

    @Override
    public void setSearchingValue() {
        this.name = stringInput.getValue("Enter group name for search");
    }
}
