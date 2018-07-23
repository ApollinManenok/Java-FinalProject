package by.itacademy.finalproject.menus.operable.scheduler;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.menus.operable.Operable;
import by.itacademy.finalproject.menus.operable.scheduler.scheduled.Scheduled;
import by.itacademy.finalproject.menus.operable.scheduler.scheduled.classroom.ClassroomInfo;

import java.util.Map;
import java.util.Set;

public class ClassroomSchedulerOperation implements Operable {
    private School school;
    private Scheduled<ClassroomInfo> scheduler;

    public ClassroomSchedulerOperation(School school, Scheduled<ClassroomInfo> scheduler) {
        this.school = school;
        this.scheduler = scheduler;
    }

    @Override
    public void operate() {
        scheduler.setSearchingValue();
        Map<String, Set<ClassroomInfo>> classroomsSchedules = scheduler.compose(school.getGroups());
        if (classroomsSchedules.isEmpty()) System.out.println("Classroom was not found");
        else for (String name : classroomsSchedules.keySet())
            print(classroomsSchedules.get(name), name);
    }

    private void print(Set<ClassroomInfo> classroomSchedules, String name) {
        System.out.println("Classroom \"" + name + "\":");
        for (ClassroomInfo info : classroomSchedules) {
            System.out.println("\t" + info.getPeriod() + "  Group: " + info.getGroup()
                    + "  Teacher: " + info.getTeacher());
        }
        System.out.println();
    }

    @Override
    public String typo() {
        return null;
    }
}
