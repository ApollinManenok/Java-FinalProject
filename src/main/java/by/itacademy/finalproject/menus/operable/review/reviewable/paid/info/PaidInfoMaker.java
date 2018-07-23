package by.itacademy.finalproject.menus.operable.review.reviewable.paid.info;

import by.itacademy.finalproject.domain.group.Payment;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.menus.operable.review.reviewable.InfoMaker;

import java.time.LocalDate;

public class PaidInfoMaker implements InfoMaker<PaidInfo, Student> {
    private LocalDate earliest;
    private LocalDate middle;
    private LocalDate latest;

    @Override
    public PaidInfo getInfo(Student student) {
        refreshDate();
        Payment previous = null;
        Payment current = null;
        for (Payment payment : student.getPayments()) {
            boolean term = payment.getDate().isAfter(earliest) && payment.getDate().isBefore(latest);
            if (term && payment.getDate().isBefore(middle)) previous = payment;
            else if (term) current = payment;
        }
        return new PaidInfo(student.getName(), previous, current);
    }

    private void refreshDate() {
        earliest = LocalDate.now().withDayOfMonth(1).minusMonths(1).minusDays(1);
        middle = LocalDate.now().withDayOfMonth(1);
        latest = LocalDate.now().withDayOfMonth(1).plusMonths(1);
    }
}
