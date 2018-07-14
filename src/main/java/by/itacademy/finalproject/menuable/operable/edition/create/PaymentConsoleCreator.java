package by.itacademy.finalproject.menuable.operable.edition.create;

import by.itacademy.finalproject.domain.Payment;
import by.itacademy.finalproject.domain.formatter.DateTimeFormat;
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
