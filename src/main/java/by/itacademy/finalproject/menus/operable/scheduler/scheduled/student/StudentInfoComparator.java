package by.itacademy.finalproject.menus.operable.scheduler.scheduled.student;

import by.itacademy.finalproject.domain.group.schedule.OverlapClassTimeComparator;

import java.util.Comparator;

public class StudentInfoComparator implements Comparator<StudentInfo> {
    @Override
    public int compare(StudentInfo one, StudentInfo two) {
        int result = new OverlapClassTimeComparator().compare(one.getPeriod(), two.getPeriod());
        if (result != 0) return result;
        return one.getGroup().compareTo(two.getGroup());
    }
}
