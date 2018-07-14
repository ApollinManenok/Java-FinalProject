package by.itacademy.finalproject.menuable.operable.edition.create;

import by.itacademy.finalproject.domain.Payment;
import by.itacademy.finalproject.domain.Student;
import by.itacademy.finalproject.domain.formatter.DateTimeFormat;
import by.itacademy.finalproject.inputable.LocalDateInput;
import by.itacademy.finalproject.inputable.StringInput;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class StudentConsoleCreator implements ConsoleCreator<Student> {
    private StringInput stringInput = new StringInput();
    private LocalDateInput localDateInput = new LocalDateInput(DateTimeFormat.D_M_YYYY_DOT.getFormat());
    private PaymentConsoleCreator paymentCreator = new PaymentConsoleCreator();

    @Override
    public Student createInstance() {
        String name = stringInput.getValue("Enter student name");
        LocalDate bDay = localDateInput.getValue("Enter student birthday (" + DateTimeFormat.D_M_YYYY_DOT + ")");
        Set<Payment> payments = new HashSet<>();
        if ("Y".equalsIgnoreCase(stringInput.getValue("Do you want to add payments? (Y/N)"))) {
            fillPayments(payments);
        }
        return new Student(name, bDay, payments);
    }

    private void fillPayments(Set<Payment> payments) {
        boolean term;
        do {
            payments.add(paymentCreator.createInstance());
            term = "Y".equalsIgnoreCase(stringInput.getValue("Do you want to add else payment? (Y/N)"));
        } while (term);
    }
}
