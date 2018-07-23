package by.itacademy.finalproject.menus.operable.review;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.group.Payment;
import by.itacademy.finalproject.menus.operable.Operable;
import by.itacademy.finalproject.menus.operable.review.reviewable.Reviewable;
import by.itacademy.finalproject.menus.operable.review.reviewable.paid.info.PaidInfo;

import java.util.List;

public class PaidReviewingOperation implements Operable {
    private School school;
    private Reviewable<PaidInfo> reviewer;

    public PaidReviewingOperation(School school, Reviewable<PaidInfo> reviewer) {
        this.school = school;
        this.reviewer = reviewer;
    }

    @Override
    public void operate() {
        List<PaidInfo> infos = reviewer.review(school.getGroups());
        if (infos.isEmpty()) System.out.println("There is no payment data yet");
        else for (PaidInfo info : infos) {
            System.out.println(prettyName(info.getName()) + " Previous month: "
                    + convertInfo(info.getPrevious()) + "\n                     This month: "
                    + convertInfo(info.getCurrent()));
        }
    }

    private String prettyName(String str) {
        StringBuffer buffer = new StringBuffer(20);
        if (str.length() < 20) buffer.append(str)
                .append("                    ", 0, 20 - str.length());
        else buffer.append(str);
        return buffer.toString();
    }

    private String convertInfo(Payment payment) {
        if (payment == null) return "No payment";
        else return payment.toString();
    }

    @Override
    public String typo() {
        return reviewer.typo();
    }
}
