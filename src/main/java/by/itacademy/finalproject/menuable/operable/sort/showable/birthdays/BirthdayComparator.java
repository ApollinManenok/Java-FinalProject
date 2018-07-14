package by.itacademy.finalproject.menuable.operable.sort.showable.birthdays;

import java.time.LocalDate;
import java.util.Comparator;

public class BirthdayComparator implements Comparator<LocalDate> {
    @Override
    public int compare(LocalDate one, LocalDate two) {
        return one.getDayOfYear() - two.getDayOfYear();
    }
}
