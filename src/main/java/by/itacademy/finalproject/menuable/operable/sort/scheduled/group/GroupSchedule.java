package by.itacademy.finalproject.menuable.operable.sort.scheduled.group;

import by.itacademy.finalproject.domain.Group;
import by.itacademy.finalproject.domain.schedule.TimePeriod;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menuable.operable.sort.scheduled.Scheduled;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class GroupSchedule implements Scheduled {
    private TreeMap<String, TreeSet<GroupInfo>> groupMap = new TreeMap<>();

    public void scheduled(Set<Group> groups) {
        initStudents(groups);
        fillStudents(groups);
        String name = new StringInput().getValue("Enter classroom name");
        if (groupMap.keySet().contains(name)) print(name);
        else print();
    }

    private void initStudents(Set<Group> groups) {
        for (Group group : groups) {
            groupMap.put(group.getName(), new TreeSet<GroupInfo>(new GroupInfoComparator()));
        }
    }

    private void fillStudents(Set<Group> groups) {
        for (Group group : groups) {
            for (TimePeriod period : group.getSchedule().getTimetable()) {
                groupMap.get(group.getName()).add(new GroupInfo(period, group.getClassroom().getName(), group.getTeacher().getName()));
            }
        }
    }

    private void print() {
        for (String name : groupMap.keySet()) {
            System.out.println("Group name: " + name + infoToString(groupMap.get(name)));
        }
    }

    private void print(String name) {
        System.out.println("Group name: " + name + infoToString(groupMap.get(name)));
    }

    private String infoToString(TreeSet<GroupInfo> groupInfos) {
        StringBuffer buffer = new StringBuffer();
        for (GroupInfo info : groupInfos) {
            buffer.append(info.getPeriod()).append(" Classroom: ").append(info.getClassroom())
                    .append(" Teacher: ").append(info.getTeacher()).append("\n");
        }
        return buffer.toString();
    }

    public String typo() {
        return "Print group(s) schedule";
    }
}
