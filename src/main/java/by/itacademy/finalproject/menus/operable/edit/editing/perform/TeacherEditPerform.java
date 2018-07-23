package by.itacademy.finalproject.menus.operable.edit.editing.perform;

import by.itacademy.finalproject.domain.group.Teacher;
import by.itacademy.finalproject.domain.group.formatter.DateTimeFormat;
import by.itacademy.finalproject.inputable.LocalDateInput;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menus.operable.edit.editing.Edit;
import by.itacademy.finalproject.menus.operable.edit.editing.EntityType;

import java.time.LocalDate;

@EntityType(type = "teacher")
public class TeacherEditPerform implements EditPerform<Teacher> {
    private StringInput stringInput = new StringInput();
    private LocalDateInput localDateInput = new LocalDateInput(DateTimeFormat.D_M_YYYY_DOT.getFormat());

    @Edit(typo = "Edit teacher's name", name = "name")
    public boolean editName(Teacher teacher) {
        System.out.println("Teacher current name \"" + teacher.getName() + "\"");
        String newName = stringInput.getValue("Enter new name");
        if (!teacher.getName().equals(newName)) {
            teacher.setName(newName);
            return true;
        }
        System.out.println("Name is the same");
        return false;
    }

    @Edit(typo = "Edit teacher's birthday", name = "birthday")
    public boolean editBirthday(Teacher teacher) {
        System.out.println("Teacher current birthday \"" + teacher.getbDay() + "\"");
        LocalDate newbDate = localDateInput.getValue("Enter new birth date(" + DateTimeFormat.D_M_YYYY_DOT + ")");
        if (!teacher.getbDay().equals(newbDate)) {
            teacher.setbDay(newbDate);
            return true;
        }
        System.out.println("Date is the same");
        return false;
    }
}
