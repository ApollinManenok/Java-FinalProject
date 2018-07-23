package by.itacademy.finalproject.menus.operable.review;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.group.formatter.DateTimeFormat;
import by.itacademy.finalproject.menus.operable.Operable;
import by.itacademy.finalproject.menus.operable.review.reviewable.Reviewable;
import by.itacademy.finalproject.menus.operable.review.reviewable.birthdays.info.BirthdayInfo;

import java.util.List;

public class BirthdayReviewingOperation implements Operable {
    private School school;
    private Reviewable<BirthdayInfo> reviewer;

    public BirthdayReviewingOperation(School school, Reviewable<BirthdayInfo> reviewer) {
        this.school = school;
        this.reviewer = reviewer;
    }

    @Override
    public void operate() {
        List<BirthdayInfo> infos = reviewer.review(school.getGroups());
        if (infos.isEmpty()) System.out.println("There are no birthdays");
        else for (BirthdayInfo info : infos) {
            System.out.println(info.getDate().format(DateTimeFormat.D_M_YYYY_DASH.getFormat()) + " "
                    + info.getType() + " " + info.getName());
        }
    }

    @Override
    public String typo() {
        return reviewer.typo();
    }
}
