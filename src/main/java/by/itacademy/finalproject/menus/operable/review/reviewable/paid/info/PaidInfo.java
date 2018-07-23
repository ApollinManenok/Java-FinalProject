package by.itacademy.finalproject.menus.operable.review.reviewable.paid.info;

import by.itacademy.finalproject.domain.group.Payment;

public class PaidInfo {
    private String name;
    private Payment previous;
    private Payment current;

    public PaidInfo(String name, Payment previous, Payment current) {
        this.name = name;
        this.previous = previous;
        this.current = current;
    }

    public String getName() {
        return name;
    }

    public Payment getPrevious() {
        return previous;
    }

    public Payment getCurrent() {
        return current;
    }

    @Override
    public String toString() {
        return name + " " + previous + " " + current;
    }
}
