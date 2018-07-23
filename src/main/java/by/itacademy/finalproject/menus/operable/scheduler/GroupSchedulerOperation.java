package by.itacademy.finalproject.menus.operable.scheduler;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.menus.operable.Operable;
import by.itacademy.finalproject.menus.operable.scheduler.scheduled.Scheduled;
import by.itacademy.finalproject.menus.operable.scheduler.scheduled.group.GroupInfo;

import java.util.Map;
import java.util.Set;

public class GroupSchedulerOperation implements Operable {
    private School school;
    private Scheduled<GroupInfo> scheduler;

    public GroupSchedulerOperation(School school, Scheduled<GroupInfo> scheduler) {
        this.school = school;
        this.scheduler = scheduler;
    }

    @Override
    public void operate() {
        scheduler.setSearchingValue();
        Map<String, Set<GroupInfo>> groups = scheduler.compose(school.getGroups());
        if (groups.isEmpty()) System.out.println("Group was not found");
        else for (String name : groups.keySet())
            print(groups.get(name), name);
    }

    private void print(Set<GroupInfo> groupsSchedules, String name) {
        System.out.println("Group \"" + name + "\":");
        for (GroupInfo info : groupsSchedules) {
            System.out.println("\t" + info.getPeriod() + "  Teacher: " + info.getTeacher()
                    + "  Classroom: " + info.getClassroom());
        }
        System.out.println();
    }

    @Override
    public String typo() {
        return null;
    }
}
