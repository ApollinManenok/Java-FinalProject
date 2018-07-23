package by.itacademy.finalproject.menus.operable.scheduler.scheduled.group;

import by.itacademy.finalproject.domain.group.schedule.OverlapClassTimeComparator;

import java.util.Comparator;

public class GroupInfoComparator implements Comparator<GroupInfo> {
    @Override
    public int compare(GroupInfo one, GroupInfo two) {
        return new OverlapClassTimeComparator().compare(one.getPeriod(), two.getPeriod());
    }
}
