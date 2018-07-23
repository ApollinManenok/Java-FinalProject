package by.itacademy.finalproject.menus.operable.scheduler.scheduled.classroom;

import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.schedule.TimePeriod;
import by.itacademy.finalproject.menus.operable.scheduler.scheduled.Scheduled;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ClassroomsSchedule implements Scheduled<ClassroomInfo> {
    @Override
    public Map<String, Set<ClassroomInfo>> compose(Set<Group> groups) {
        Map<String, Set<ClassroomInfo>> classrooms = new TreeMap<>();
        for (Group group : groups) {
            fillSchedule(group, classrooms);
        }
        return classrooms;
    }

    @Override
    public void setSearchingValue() {
    }

    private void fillSchedule(Group group, Map<String, Set<ClassroomInfo>> classrooms) {
        Set<ClassroomInfo> infos = new TreeSet<>(new ClassroomInfoComparator());
        for (TimePeriod period : group.getSchedule().getTimetable()) {
            infos.add(new ClassroomInfo(period, group.getName(), group.getTeacher().getName()));
        }
        if (classrooms.containsKey(group.getClassroom().getName())) {
            classrooms.get(group.getClassroom().getName()).addAll(infos);
        } else classrooms.put(group.getClassroom().getName(), infos);
    }

    @Override
    public String typo() {
        return "Print classrooms schedule";
    }
}
