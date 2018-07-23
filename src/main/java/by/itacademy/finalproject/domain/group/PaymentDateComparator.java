package by.itacademy.finalproject.domain.group;

import java.util.Comparator;

public class PaymentDateComparator implements Comparator<Payment> {
    @Override
    public int compare(Payment one, Payment two) {
        return one.getDate().compareTo(two.getDate());
    }
}
