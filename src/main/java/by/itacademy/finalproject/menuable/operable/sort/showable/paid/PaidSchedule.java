package by.itacademy.finalproject.menuable.operable.sort.showable.paid;

import by.itacademy.finalproject.domain.Group;
import by.itacademy.finalproject.domain.Payment;
import by.itacademy.finalproject.domain.Student;
import by.itacademy.finalproject.domain.formatter.DateTimeFormat;
import by.itacademy.finalproject.menuable.operable.sort.showable.birthdays.BirthdayInfo;
import by.itacademy.finalproject.menuable.operable.sort.showable.birthdays.BirthdayInfoComparator;

import java.time.LocalDate;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class PaidSchedule {
    private Set<PaidInfo> payments = new TreeSet<>(new PaidInfoComparator());

    public void showPaid(Set<Group> groups) {
        fillPayments(groups);
        print();
    }

    private void fillPayments(Set<Group> groups) {
        for (Group group : groups) {
            for (Student student : group.getStudents()) {
                PaidInfo info;
                if (student.getPayments().isEmpty()) {
                    info = new PaidInfo(student.getName(), false, false);
                } else {
                    boolean previouse = false;
                    boolean current = false;
                    for (Payment payment : student.getPayments()) {
                        if (payment.getDate().isAfter(LocalDate.now().withDayOfMonth(0))) {
                            current = true;
                        }else if (payment.getDate().isAfter(LocalDate.now().minusMonths(1).withDayOfMonth(0)))
                            previouse = true;
                    }
                    info = new PaidInfo(student.getName(), previouse, current);
                }
                if(payments.contains(info)){
                    //get object, compare objects, refresh
                }
                payments.add(info);
            }
        }
    }

    private void print() {
        for (PaidInfo info : payments) {
            /*System.out.println(info.getDate().format(DateTimeFormat.D_M_YYYY_DASH.getFormat()) + " "
                    + info.getType() + " " + info.getName());*/
        }
    }

    public String typo() {
        return "Print birthday Guys!";
    }
}
