package by.itacademy.finalproject.menus.operable.scheduler.scheduled.student;

import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.domain.group.schedule.TimePeriod;
import by.itacademy.finalproject.menus.operable.scheduler.scheduled.Scheduled;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class StudentsSchedule implements Scheduled<StudentInfo> {
    @Override
    public Map<String, Set<StudentInfo>> compose(Set<Group> groups) {
        Map<String, Set<StudentInfo>> studentsInfo = new TreeMap<>();
        for (Group group : groups) {
            fillSchedule(group, studentsInfo);
        }
        return studentsInfo;
    }

    private void fillSchedule(Group group, Map<String, Set<StudentInfo>> studentsInfo) {
        for (Student student : group.getStudents()) {
            Set<StudentInfo> infos = new TreeSet<>(new StudentInfoComparator());
            for (TimePeriod period : group.getSchedule().getTimetable()) {
                infos.add(new StudentInfo(period, group.getName(), group.getClassroom().getName(), group.getTeacher().getName()));
            }
            if (studentsInfo.containsKey(student.getName())) {
                studentsInfo.get(student.getName()).addAll(infos);
            } else studentsInfo.put(student.getName(), infos);
        }
    }

    @Override
    public void setSearchingValue() {
    }

    @Override
    public String typo() {
        return "Print students schedule";
    }
}
