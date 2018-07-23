package by.itacademy.finalproject.menus.operable.scheduler;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.menus.operable.Operable;
import by.itacademy.finalproject.menus.operable.scheduler.scheduled.Scheduled;
import by.itacademy.finalproject.menus.operable.scheduler.scheduled.student.StudentInfo;

import java.util.Map;
import java.util.Set;

public class StudentSchedulerOperation implements Operable {
    private School school;
    private Scheduled<StudentInfo> scheduler;

    public StudentSchedulerOperation(School school, Scheduled<StudentInfo> scheduler) {
        this.school = school;
        this.scheduler = scheduler;
    }

    @Override
    public void operate() {
        scheduler.setSearchingValue();
        Map<String, Set<StudentInfo>> studentsSchedules = scheduler.compose(school.getGroups());
        if (studentsSchedules.isEmpty()) System.out.println("Student was not found");
        else for (String name : studentsSchedules.keySet())
            print(studentsSchedules.get(name), name);
    }

    private void print(Set<StudentInfo> studentsSchedules, String name) {
        System.out.println("Student \"" + name + "\":");
        for (StudentInfo info : studentsSchedules) {
            System.out.println("\t" + info.getPeriod() + "  Group: " + info.getGroup()
                    + "  Teacher: " + info.getTeacher() + "  Classroom: " + info.getClassroom());
        }
        System.out.println();
    }

    @Override
    public String typo() {
        return null;
    }
}
