package by.itacademy.finalproject.menuable.operable.sort.showable.paid;

import java.util.Comparator;

public class PaidInfoComparator implements Comparator<PaidInfo> {
    @Override
    public int compare(PaidInfo one, PaidInfo two) {
        return one.getName().compareTo(two.getName());
    }
}
