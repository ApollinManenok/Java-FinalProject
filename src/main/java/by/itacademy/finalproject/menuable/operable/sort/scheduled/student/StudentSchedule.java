package by.itacademy.finalproject.menuable.operable.sort.scheduled.student;

import by.itacademy.finalproject.domain.Group;
import by.itacademy.finalproject.domain.schedule.TimePeriod;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menuable.operable.sort.scheduled.Scheduled;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class StudentSchedule implements Scheduled {
    private TreeMap<String, PriorityQueue<StudentInfo>> studentMap = new TreeMap<>();

    public void scheduled(Set<Group> groups) {
        initStudents(groups);
        fillStudents(groups);
        String name = new StringInput().getValue("Enter classroom name");
        if (studentMap.keySet().contains(name)) print(name);
        else print();
    }

    private void initStudents(Set<Group> groups) {
        for (Group group : groups) {
            studentMap.put(group.getName(), new PriorityQueue<StudentInfo>(new StudentInfoComparator()));
        }
    }

    private void fillStudents(Set<Group> groups) {
        for (Group group : groups) {
            for (TimePeriod period : group.getSchedule().getTimetable()) {
                studentMap.get(group.getName()).add(new StudentInfo(period, group.getName(), group.getClassroom().getName(), group.getTeacher().getName()));
            }
        }
    }

    private void print() {
        for (String name : studentMap.keySet()) {
            System.out.println("Group name: " + name + infoToString(studentMap.get(name)));
        }
    }

    private void print(String name) {
        System.out.println("Group name: " + name + infoToString(studentMap.get(name)));
    }

    private String infoToString(PriorityQueue<StudentInfo> studentInfos) {
        StringBuffer buffer = new StringBuffer();
        for (StudentInfo info : studentInfos) {
            buffer.append(info.getPeriod()).append(" Classroom: ").append(info.getClassroom())
                    .append(" Teacher: ").append(info.getTeacher()).append("\n");
        }
        return buffer.toString();
    }

    public String typo() {
        return "Print student(s) schedule";
    }
}
