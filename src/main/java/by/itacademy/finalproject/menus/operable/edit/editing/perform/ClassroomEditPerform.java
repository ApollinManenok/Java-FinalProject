package by.itacademy.finalproject.menus.operable.edit.editing.perform;

import by.itacademy.finalproject.domain.group.Classroom;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menus.operable.edit.editing.Edit;
import by.itacademy.finalproject.menus.operable.edit.editing.EntityType;

@EntityType(type = "classroom")
public class ClassroomEditPerform implements EditPerform<Classroom> {
    private StringInput stringInput = new StringInput();

    @Edit(typo = "Change classroom's name", name = "name")
    public boolean editName(Classroom classroom) {
        System.out.println("Classroom current name \"" + classroom.getName() + "\"");
        String newName = stringInput.getValue("Enter new name or \"Cancel\"");
        if (newName.equalsIgnoreCase("CANCEL")) return false;
        if (!classroom.getName().equals(newName)) {
            classroom.setName(newName);
        }
        return true;
    }
}
