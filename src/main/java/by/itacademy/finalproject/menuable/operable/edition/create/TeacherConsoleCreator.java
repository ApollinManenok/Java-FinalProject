package by.itacademy.finalproject.menuable.operable.edition.create;

import by.itacademy.finalproject.domain.FutureDateTimeException;
import by.itacademy.finalproject.domain.Teacher;
import by.itacademy.finalproject.domain.formatter.DateTimeFormat;
import by.itacademy.finalproject.inputable.LocalDateInput;
import by.itacademy.finalproject.inputable.StringInput;

import java.time.LocalDate;

public class TeacherConsoleCreator implements ConsoleCreator<Teacher> {
    private StringInput stringInput = new StringInput();
    private LocalDateInput localDateInput = new LocalDateInput(DateTimeFormat.D_M_YYYY_DOT.getFormat());

    @Override
    public Teacher createInstance() throws FutureDateTimeException {
        String name = stringInput.getValue("Enter teacher name");
        LocalDate bDay = localDateInput.getValue("Enter teacher birthday (" + DateTimeFormat.D_M_YYYY_DOT + ")");
        return new Teacher(name, bDay);
    }
}
