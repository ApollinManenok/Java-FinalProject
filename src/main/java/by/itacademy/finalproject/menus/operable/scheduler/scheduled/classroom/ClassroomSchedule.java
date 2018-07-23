package by.itacademy.finalproject.menus.operable.scheduler.scheduled.classroom;

import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.schedule.TimePeriod;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menus.operable.scheduler.scheduled.Scheduled;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ClassroomSchedule implements Scheduled<ClassroomInfo> {
    private StringInput stringInput = new StringInput();
    private String classroomName;

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    @Override
    public Map<String, Set<ClassroomInfo>> compose(Set<Group> groups) {
        Map<String, Set<ClassroomInfo>> classrooms = new TreeMap<>();
        for (Group group : groups)
            if (group.getClassroom().getName().equalsIgnoreCase(classroomName))
                fillSchedule(group, classrooms);
        return classrooms;
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
    public void setSearchingValue() {
        this.classroomName = stringInput.getValue("Enter classroom name");
    }

    @Override
    public String typo() {
        return "Print classroom schedule";
    }
}
