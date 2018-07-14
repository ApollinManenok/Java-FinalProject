package by.itacademy.finalproject.menuable.operable.sort.scheduled.group;

import by.itacademy.finalproject.domain.schedule.OverlapClassTimeComparator;

import java.util.Comparator;

public class GroupInfoComparator implements Comparator<GroupInfo> {
    @Override
    public int compare(GroupInfo one, GroupInfo two) {
        return new OverlapClassTimeComparator().compare(one.getPeriod(), two.getPeriod());
    }
}
