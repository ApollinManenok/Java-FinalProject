package by.itacademy.finalproject.menuable.operable.sort.scheduled.student;

import by.itacademy.finalproject.domain.schedule.TimePeriod;

public class StudentInfo {
    private TimePeriod period;
    private String group;
    private String classroom;
    private String teacher;

    public StudentInfo(TimePeriod period, String group, String classroom, String teacher) {
        this.period = period;
        this.group = group;
        this.classroom = classroom;
        this.teacher = teacher;
    }

    public TimePeriod getPeriod() {
        return period;
    }

    public String getGroup() {
        return group;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getTeacher() {
        return teacher;
    }
}
