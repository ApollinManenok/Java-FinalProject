package by.itacademy.finalproject.menus.operable.edit.creator;

import by.itacademy.finalproject.domain.group.Classroom;
import by.itacademy.finalproject.inputable.StringInput;

public class ClassroomConsoleCreator implements ConsoleCreator<Classroom> {
    private StringInput stringInput = new StringInput();

    @Override
    public Classroom createInstance() {
        String name = stringInput.getValue("Enter classroom name");
        return new Classroom(name);
    }
}
