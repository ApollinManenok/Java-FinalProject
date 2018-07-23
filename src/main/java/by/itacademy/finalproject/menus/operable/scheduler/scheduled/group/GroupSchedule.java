package by.itacademy.finalproject.menus.operable.scheduler.scheduled.group;

import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.schedule.TimePeriod;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menus.operable.scheduler.scheduled.Scheduled;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class GroupSchedule implements Scheduled<GroupInfo> {
    private StringInput stringInput = new StringInput();
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Map<String, Set<GroupInfo>> compose(Set<Group> groups) {
        Map<String, Set<GroupInfo>> groupsInfos = new TreeMap<>();
        for (Group group : groups) {
            if (group.getName().equalsIgnoreCase(name))
                fillSchedule(group, groupsInfos);
        }
        return groupsInfos;
    }

    private void fillSchedule(Group group, Map<String, Set<GroupInfo>> groupsInfos) {
        Set<GroupInfo> infos = new TreeSet<>(new GroupInfoComparator());
        for (TimePeriod period : group.getSchedule().getTimetable()) {
            infos.add(new GroupInfo(period, group.getTeacher().getName(), group.getClassroom().getName()));
        }
        if (groupsInfos.containsKey(group.getName())) {
            groupsInfos.get(group.getName()).addAll(infos);
        } else groupsInfos.put(group.getName(), infos);
    }

    @Override
    public void setSearchingValue() {
        this.name = stringInput.getValue("Enter group name");
    }

    @Override
    public String typo() {
        return "Print group schedule";
    }
}
