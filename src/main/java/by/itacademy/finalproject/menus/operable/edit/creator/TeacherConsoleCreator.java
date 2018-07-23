package by.itacademy.finalproject.menus.operable.edit.creator;

import by.itacademy.finalproject.domain.group.Teacher;
import by.itacademy.finalproject.domain.group.formatter.DateTimeFormat;
import by.itacademy.finalproject.inputable.LocalDateInput;
import by.itacademy.finalproject.inputable.StringInput;

import java.time.LocalDate;

public class TeacherConsoleCreator implements ConsoleCreator<Teacher> {
    private StringInput stringInput = new StringInput();
    private LocalDateInput localDateInput = new LocalDateInput(DateTimeFormat.D_M_YYYY_DOT.getFormat());

    @Override
    public Teacher createInstance() {
        String name = stringInput.getValue("Enter teacher name");
        LocalDate bDay = localDateInput.getValue("Enter teacher birthday (" + DateTimeFormat.D_M_YYYY_DOT + ")");
        return new Teacher(name, bDay);
    }
}
