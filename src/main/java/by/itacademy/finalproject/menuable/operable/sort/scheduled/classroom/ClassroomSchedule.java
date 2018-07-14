package by.itacademy.finalproject.menuable.operable.sort.scheduled.classroom;

import by.itacademy.finalproject.domain.Group;
import by.itacademy.finalproject.domain.schedule.TimePeriod;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menuable.operable.sort.scheduled.Scheduled;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ClassroomSchedule implements Scheduled {
    private TreeMap<String, TreeSet<ClassroomInfo>> roomMap = new TreeMap<>();

    public void scheduled(Set<Group> groups) {
        initStudents(groups);
        fillStudents(groups);
        String name = new StringInput().getValue("Enter classroom name");
        if (roomMap.keySet().contains(name)) print(name);
        else print();
    }

    private void initStudents(Set<Group> groups) {
        for (Group group : groups) {
            roomMap.put(group.getClassroom().getName(), new TreeSet<>(new ClassroomInfoComparator()));
        }
    }

    private void fillStudents(Set<Group> groups) {
        for (Group group : groups) {
            for (TimePeriod period : group.getSchedule().getTimetable()) {
                roomMap.get(group.getClassroom().getName()).add(new ClassroomInfo(period, group.getName(), group.getTeacher().getName()));
            }
        }
    }

    private void print() {
        for (String name : roomMap.keySet()) {
            System.out.println("Classroom name: " + name + infoToString(roomMap.get(name)));
        }
    }

    private void print(String name) {
        System.out.println("Classroom name: " + name + infoToString(roomMap.get(name)));
    }

    private String infoToString(TreeSet<ClassroomInfo> classroomInfos) {
        StringBuffer buffer = new StringBuffer();
        for (ClassroomInfo info : classroomInfos) {
            buffer.append(info.getPeriod()).append(" Group: ").append(info.getGroup())
                    .append(" Teacher: ").append(info.getTeacher()).append("\n");
        }
        return buffer.toString();
    }

    public String typo() {
        return "Print classroom(s) schedule";
    }
}
