package by.itacademy.finalproject.menus.operable.search.searchable;

import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.domain.group.StudentNameComparator;
import by.itacademy.finalproject.inputable.IntegerInput;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class AgeSearch implements Searchable {
    private IntegerInput integerInput = new IntegerInput();
    private int age;

    public void setAge(int age) throws NegativeAgeException {
        if (age <= 0) throw new NegativeAgeException("Age equals " + age);
        else this.age = age;
    }

    @Override
    public Set<Student> search(Set<Group> groups) {
        Set<Student> students = new TreeSet<>(new StudentNameComparator());
        for (Group group : groups)
            checkedFill(group, students);
        return students;
    }

    private void checkedFill(Group group, Set<Student> students) {
        for (Student student : group.getStudents()) {
            if (countAge(student.getbDay()) == age)
                students.add(student);
        }
    }

    private int countAge(LocalDate birthday) {
        int age = LocalDate.now().getYear() - birthday.getYear();
        if (LocalDate.now().getDayOfYear() < birthday.getDayOfYear()) age -= 1;
        return age;
    }

    @Override
    public void setSearchingValue() {
        int tempAge = 0;
        while (tempAge == 0) {
            tempAge = integerInput.getValue("Enter student age for search");
            if (tempAge <= 0) System.out.println("Age can't be less than 1");
            else {
                this.age = tempAge;
                break;
            }
        }
    }

    @Override
    public String typo() {
        return "Search by age";
    }
}
