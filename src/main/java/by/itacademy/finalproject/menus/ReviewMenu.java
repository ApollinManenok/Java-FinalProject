package by.itacademy.finalproject.menus;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.inputable.IntegerInput;
import by.itacademy.finalproject.menus.operable.Operable;
import by.itacademy.finalproject.menus.operable.review.BirthdayReviewingOperation;
import by.itacademy.finalproject.menus.operable.review.PaidReviewingOperation;
import by.itacademy.finalproject.menus.operable.review.reviewable.birthdays.BirthdayReviewer;
import by.itacademy.finalproject.menus.operable.review.reviewable.birthdays.ResentBirthdayReviewer;
import by.itacademy.finalproject.menus.operable.review.reviewable.paid.DebtPaymentsReviewer;
import by.itacademy.finalproject.menus.operable.review.reviewable.paid.PaidPaymentsReviewer;
import by.itacademy.finalproject.menus.operable.review.reviewable.paid.PaymentsReviewer;

import java.util.ArrayList;

public class ReviewMenu implements Menuable {
    private ArrayList<Operable> options = new ArrayList<>();

    public ReviewMenu(School school) {
        options.add(new BirthdayReviewingOperation(school, new BirthdayReviewer()));
        options.add(new BirthdayReviewingOperation(school, new ResentBirthdayReviewer()));
        options.add(new PaidReviewingOperation(school, new PaymentsReviewer()));
        options.add(new PaidReviewingOperation(school, new PaidPaymentsReviewer()));
        options.add(new PaidReviewingOperation(school, new DebtPaymentsReviewer()));
    }

    @Override
    public void list() throws RangeException {
        boolean term = true;
        while (term) {
            System.out.println("Menu list:\n0. Exit");
            for (int i = 0; i < options.size(); i++) {
                System.out.println(i + 1 + ". " + options.get(i).typo());
            }
            int index = new IntegerInput().getValue("Enter menu number");
            term = operate(index);
        }
    }

    private boolean operate(int index) throws RangeException {
        if (index < 0 || index > this.options.size())
            throw new RangeException("Index out of list range");
        else if (index == 0)
            return false;
        index -= 1;
        options.get(index).operate();
        return true;
    }

    @Override
    public String typo() {
        return "Review birthday or payments info";
    }
}
