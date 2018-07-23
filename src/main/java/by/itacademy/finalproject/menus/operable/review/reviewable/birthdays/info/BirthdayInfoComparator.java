package by.itacademy.finalproject.menus.operable.review.reviewable.birthdays.info;

import java.util.Comparator;

public class BirthdayInfoComparator implements Comparator<BirthdayInfo> {
    @Override
    public int compare(BirthdayInfo one, BirthdayInfo two) {
        int result = one.getDate().getDayOfYear() - two.getDate().getDayOfYear();
        if (result != 0) return result;
        if (one.getType().equalsIgnoreCase("Teacher") && !two.getType().equalsIgnoreCase("Teacher")) return -1;
        if (!one.getType().equalsIgnoreCase("Teacher") && two.getType().equalsIgnoreCase("Teacher")) return 1;
        if (!one.getName().equals(two.getName())) return one.getName().compareTo(two.getName());
        if (!one.getDate().isEqual(two.getDate())) return one.getDate().compareTo(two.getDate());
        return 0;
    }
}
