package by.itacademy.finalproject.menus.operable.edit.creator;

import by.itacademy.finalproject.domain.group.Payment;
import by.itacademy.finalproject.domain.group.formatter.DateTimeFormat;
import by.itacademy.finalproject.inputable.IntegerInput;
import by.itacademy.finalproject.inputable.LocalDateInput;

import java.time.LocalDate;

public class PaymentConsoleCreator implements ConsoleCreator<Payment> {
    private LocalDateInput localDateInput = new LocalDateInput(DateTimeFormat.D_M_YYYY_DOT.getFormat());
    private IntegerInput integerInput = new IntegerInput();

    @Override
    public Payment createInstance() {
        LocalDate date = localDateInput.getValue("Enter payment date (" + DateTimeFormat.D_M_YYYY_DOT + ")");
        int amount = integerInput.getValue("Enter payment amount");
        return new Payment(date, amount);
    }
}
