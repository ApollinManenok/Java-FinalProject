package by.itacademy.finalproject.menus.operable.search.searchable;

import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.domain.group.StudentNameComparator;
import by.itacademy.finalproject.inputable.StringInput;

import java.util.Set;
import java.util.TreeSet;

public class NameSearch implements Searchable {
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
        for (Student student : group.getStudents()) {
            if (student.getName().contains(name) || student.getName().equalsIgnoreCase(name))
                students.add(student);
        }
    }

    @Override
    public String typo() {
        return "Search by name";
    }

    @Override
    public void setSearchingValue() {
        this.name = stringInput.getValue("Enter student name for search");
    }
}
