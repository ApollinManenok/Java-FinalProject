package by.itacademy.finalproject.menuable.operable.edition.edit.perform;

import by.itacademy.finalproject.domain.Payment;
import by.itacademy.finalproject.domain.formatter.DateTimeFormat;
import by.itacademy.finalproject.inputable.LocalDateInput;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menuable.operable.edition.create.PaymentConsoleCreator;
import by.itacademy.finalproject.menuable.operable.edition.edit.Edit;
import by.itacademy.finalproject.menuable.operable.edition.edit.EntityType;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

@EntityType(type = "payments")
public class PaymentEditPerform implements EditPerform<Set<Payment>> {
    private StringInput stringInput = new StringInput();
    private LocalDateInput localDateInput = new LocalDateInput(DateTimeFormat.D_M_YYYY_DOT.getFormat());
    private PaymentConsoleCreator creator = new PaymentConsoleCreator();

    @Edit(typo = "Add payment to payments history", name = "add")
    public boolean addPayment(Set<Payment> payments) {
        Payment student = creator.createInstance();
        if (!payments.contains(student)) {
            payments.add(student);
            System.out.println("Payment was added");
            return true;
        }
        System.out.println("Payment already exist");
        return false;
    }

    @Edit(typo = "Remove payment from payments history", name = "remove")
    public boolean removePayments(Set<Payment> payments) {
        Set<Payment> temp = getRemovable(payments);
        if (!temp.isEmpty()) {
            payments.removeAll(temp);
            return true;
        }
        return false;
    }

    @Edit(typo = "Oblivion old payments history", name = "oblivion")
    public boolean oblivionPayments(Set<Payment> payments) {
        LocalDate date = localDateInput.getValue("Enter date before which you want to oblivion payments ("
                + DateTimeFormat.D_M_YYYY_DOT + ")");
        Set<Payment> temp = getRemovable(payments, date);
        if (!temp.isEmpty()) {
            payments.removeAll(temp);
            return true;
        }
        return false;
    }

    private Set<Payment> getRemovable(Set<Payment> payments) {
        Set<Payment> temp = new TreeSet<>();
        for (Payment payment : payments) {
            System.out.println(payment);
            if ("Y".equalsIgnoreCase(stringInput.getValue("Do you wan't to remove this time? (true/false)"))) {
                temp.add(payment);
            }
        }
        return temp;
    }

    private Set<Payment> getRemovable(Set<Payment> payments, LocalDate date) {
        Set<Payment> temp = new TreeSet<>();
        for (Payment payment : payments) {
            if (payment.getDate().isBefore(date)) {
                temp.add(payment);
            }
        }
        return temp;
    }
}
