package by.itacademy.finalproject.inputable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateInput implements Inputable<LocalDate> {
    private DateTimeFormatter format;

    public LocalDateInput(DateTimeFormatter format) {
        this.format = format;
    }

    @Override
    public LocalDate getValue(String message) {
        System.out.print(message + "\n>>> ");
        return LocalDate.parse(scan.nextLine(), format);
    }
}
