package by.itacademy.finalproject.menuable.operable.sort.birthdays;

import by.itacademy.finalproject.domain.Group;
import by.itacademy.finalproject.domain.Student;
import by.itacademy.finalproject.domain.formatter.DateTimeFormat;

import java.time.LocalDate;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class BirthdaySchedule {
    private Queue<BirthdayInfo> birthdays = new PriorityQueue<>(new BirthdayInfoComparator());

    public void showBirthdays(Set<Group> groups) {
        fillBirthdays(groups);
        print();
    }

    private void fillBirthdays(Set<Group> groups) {
        for (Group group : groups) {
            if (group.getTeacher().getbDay().isAfter(LocalDate.now()) && group.getTeacher().getbDay().isBefore(LocalDate.now().plusMonths(2)))
                birthdays.add(new BirthdayInfo(group.getTeacher().getbDay(), group.getTeacher().getName(), "Teacher"));
            for (Student student : group.getStudents()) {
                birthdays.add(new BirthdayInfo(student.getbDay(), student.getName(), "Student"));
            }
        }
    }

    private void print() {
        for (BirthdayInfo info : birthdays) {
            System.out.println(info.getDate().format(DateTimeFormat.D_M_YYYY_DASH.getFormat()) + " "
                    + info.getType() + " " + info.getName());
        }
    }

    public String typo() {
        return "Print birthday Guys!";
    }
}


