package by.itacademy.finalproject.menus.operable.scheduler.scheduled.group;

import by.itacademy.finalproject.domain.group.schedule.TimePeriod;

public class GroupInfo {
    private TimePeriod period;
    private String teacher;
    private String classroom;

    public GroupInfo(TimePeriod period, String teacher, String classroom) {
        this.period = period;
        this.teacher = teacher;
        this.classroom = classroom;
    }

    public TimePeriod getPeriod() {
        return period;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getClassroom() {
        return classroom;
    }
}
