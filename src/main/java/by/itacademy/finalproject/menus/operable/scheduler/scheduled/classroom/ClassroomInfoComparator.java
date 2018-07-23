package by.itacademy.finalproject.menus.operable.scheduler.scheduled.classroom;

import by.itacademy.finalproject.domain.group.schedule.OverlapClassTimeComparator;

import java.util.Comparator;

public class ClassroomInfoComparator implements Comparator<ClassroomInfo> {
    @Override
    public int compare(ClassroomInfo one, ClassroomInfo two) {
        return new OverlapClassTimeComparator().compare(one.getPeriod(), two.getPeriod());
    }
}
