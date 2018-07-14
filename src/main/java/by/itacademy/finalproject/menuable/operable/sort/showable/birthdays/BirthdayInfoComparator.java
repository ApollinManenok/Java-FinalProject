package by.itacademy.finalproject.menuable.operable.sort.showable.birthdays;

import java.util.Comparator;

public class BirthdayInfoComparator implements Comparator<BirthdayInfo> {
    @Override
    public int compare(BirthdayInfo one, BirthdayInfo two) {
        int result = new BirthdayComparator().compare(one.getDate(), two.getDate());
        if (result != 0) return result;
        if (one.getType().equalsIgnoreCase("Teacher") && !two.getType().equalsIgnoreCase("Teacher")) return 1;
        if (!one.getType().equalsIgnoreCase("Teacher") && two.getType().equalsIgnoreCase("Teacher")) return -1;
        if (!one.getName().equals(two.getName())) return one.getName().compareTo(two.getName());
        return 0;
    }
}
