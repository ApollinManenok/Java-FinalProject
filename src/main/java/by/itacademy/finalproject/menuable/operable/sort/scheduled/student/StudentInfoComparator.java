package by.itacademy.finalproject.menuable.operable.sort.scheduled.student;

import by.itacademy.finalproject.domain.schedule.OverlapClassTimeComparator;

import java.util.Comparator;

public class StudentInfoComparator implements Comparator<StudentInfo> {
    @Override
    public int compare(StudentInfo one, StudentInfo two) {
        return new OverlapClassTimeComparator().compare(one.getPeriod(), two.getPeriod());
    }
}
