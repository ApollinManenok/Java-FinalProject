package by.itacademy.finalproject.menus.operable.review.reviewable.birthdays.info;

import java.time.LocalDate;

public class BirthdayInfo {
    private LocalDate date;
    private String name;
    private String type;

    public BirthdayInfo(LocalDate date, String name, String type) {
        this.date = date;
        this.name = name;
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
