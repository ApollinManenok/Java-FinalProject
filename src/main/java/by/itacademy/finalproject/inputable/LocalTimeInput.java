package by.itacademy.finalproject.inputable;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeInput implements Inputable<LocalTime> {
    private DateTimeFormatter format;

    public LocalTimeInput(DateTimeFormatter format) {
        this.format = format;
    }

    @Override
    public LocalTime getValue(String message) {
        System.out.print(message + "\n>>> ");
        return LocalTime.parse(scan.nextLine(), format);
    }
}
