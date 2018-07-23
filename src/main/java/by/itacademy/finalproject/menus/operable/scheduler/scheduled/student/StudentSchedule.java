package by.itacademy.finalproject.menus.operable.scheduler.scheduled.student;

import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.domain.group.schedule.TimePeriod;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menus.operable.scheduler.scheduled.Scheduled;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class StudentSchedule implements Scheduled<StudentInfo> {
    private StringInput stringInput = new StringInput();
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Map<String, Set<StudentInfo>> compose(Set<Group> groups) {
        Map<String, Set<StudentInfo>> studentsInfos = new TreeMap<>();
        for (Group group : groups) {
            findStudent(group, studentsInfos);
        }
        return studentsInfos;
    }

    private void findStudent(Group group, Map<String, Set<StudentInfo>> studentsInfos) {
        for (Student student : group.getStudents()) {
            if (student.getName().equalsIgnoreCase(name) || student.getName().contains(name))
                fillSchedule(group, student, studentsInfos);
        }
    }

    private void fillSchedule(Group group, Student student, Map<String, Set<StudentInfo>> studentsInfos) {
        Set<StudentInfo> infos = new TreeSet<>(new StudentInfoComparator());
        for (TimePeriod period : group.getSchedule().getTimetable()) {
            infos.add(new StudentInfo(period, group.getName(), group.getClassroom().getName(), group.getTeacher().getName()));
        }
        if (studentsInfos.containsKey(student.getName())) {
            studentsInfos.get(student.getName()).addAll(infos);
        } else studentsInfos.put(student.getName(), infos);
    }

    @Override
    public void setSearchingValue() {
        this.name = stringInput.getValue("Enter student name");
    }

    @Override
    public String typo() {
        return "Print student schedule";
    }
}
