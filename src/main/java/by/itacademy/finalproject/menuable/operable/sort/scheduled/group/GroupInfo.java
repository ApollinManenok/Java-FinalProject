package by.itacademy.finalproject.menuable.operable.sort.scheduled.group;

import by.itacademy.finalproject.domain.schedule.TimePeriod;

public class GroupInfo {
    private TimePeriod period;
    private String classroom;
    private String teacher;

    public GroupInfo(TimePeriod period, String classroom, String teacher) {
        this.period = period;
        this.classroom = classroom;
        this.teacher = teacher;
    }

    public TimePeriod getPeriod() {
        return period;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getTeacher() {
        return teacher;
    }
}
