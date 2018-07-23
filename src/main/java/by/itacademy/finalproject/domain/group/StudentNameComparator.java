package by.itacademy.finalproject.domain.group;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {

    @Override
    public int compare(Student one, Student two) {
        if (!one.getName().equals(two.getName())) return one.getName().compareTo(two.getName());
        if (!one.getbDay().equals(two.getbDay())) return one.getbDay().compareTo(two.getbDay());
        return one.getPayments().size() - two.getPayments().size();
    }
}
