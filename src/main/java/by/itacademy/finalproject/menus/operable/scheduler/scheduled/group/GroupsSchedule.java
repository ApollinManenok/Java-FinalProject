package by.itacademy.finalproject.menus.operable.scheduler.scheduled.group;

import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.schedule.TimePeriod;
import by.itacademy.finalproject.menus.operable.scheduler.scheduled.Scheduled;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class GroupsSchedule implements Scheduled<GroupInfo> {
    @Override
    public Map<String, Set<GroupInfo>> compose(Set<Group> groups) {
        Map<String, Set<GroupInfo>> groupsInfos = new TreeMap<>();
        for (Group group : groups) {
            fillSchedule(group, groupsInfos);
        }
        return groupsInfos;
    }

    @Override
    public void setSearchingValue() {
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
    public String typo() {
        return "Print groups schedule";
    }
}
