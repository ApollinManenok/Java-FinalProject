package by.itacademy.finalproject.domain.group.schedule;

import java.util.Comparator;

public class OverlapClassTimeComparator implements Comparator<TimePeriod> {
    @Override
    public int compare(TimePeriod one, TimePeriod two) {
        if (one.equals(two)) return 0;
        if (one.getDayOfWeek() != two.getDayOfWeek()) return one.getDayOfWeek().compareTo(two.getDayOfWeek());
        if (one.getBegin().isAfter(two.getEnd())) return 1;
        if (one.getEnd().isBefore(two.getBegin())) return -1;
        return 0;
    }
}


