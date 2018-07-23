package by.itacademy.finalproject.menus.operable.edit.editing.perform;

import by.itacademy.finalproject.domain.group.FutureDateTimeException;
import by.itacademy.finalproject.domain.group.Payment;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menus.operable.edit.creator.PaymentConsoleCreator;
import by.itacademy.finalproject.menus.operable.edit.editing.Edit;
import by.itacademy.finalproject.menus.operable.edit.editing.EntityType;

import java.util.Set;
import java.util.TreeSet;

@EntityType(type = "payments")
public class PaymentEditPerform implements EditPerform<Set<Payment>> {
    private StringInput stringInput = new StringInput();
    private PaymentConsoleCreator creator = new PaymentConsoleCreator();

    @Edit(typo = "Add payment to payments history", name = "add")
    public boolean addPayment(Set<Payment> payments) throws FutureDateTimeException {
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
}
