package by.itacademy.finalproject.domain.schedule;

import java.util.Set;
import java.util.TreeSet;

public class Schedule {
    private Set<TimePeriod> timetable = new TreeSet<>(new OverlapClassTimeComparator());

    public Schedule() {
    }

    public Schedule(Set<TimePeriod> timetable) {
        this.timetable = timetable;
    }

    public Schedule(Schedule schedule) {
        for (TimePeriod period : schedule.timetable) {
            this.timetable.add(new TimePeriod(period));
        }
    }

    public Set<TimePeriod> getTimetable() {
        return timetable;
    }

    public void addTime(TimePeriod time) throws TimeOverlapException {
        if (timetable.contains(time))
            throw new TimeOverlapException(time + " overlap existing time");
        timetable.add(time);
    }

    public boolean remove(TimePeriod time) {
        return timetable.remove(time);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Schedule other = (Schedule) object;

        if (timetable.isEmpty()) return other.timetable.isEmpty();
        for (TimePeriod timePeriod : timetable) {
            if (other.timetable.contains(timePeriod)) return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return timetable != null ? timetable.hashCode() : 0;
    }

    public String getTimetableAsString() {
        StringBuffer buffer = new StringBuffer();
        for (TimePeriod period : timetable) {
            buffer.append(period).append(", ");
        }
        buffer.delete(buffer.length() - 2, buffer.length());
        return buffer.toString();
    }

    @Override
    public String toString() {
        return "Schedule: " + timetable;
    }
}
