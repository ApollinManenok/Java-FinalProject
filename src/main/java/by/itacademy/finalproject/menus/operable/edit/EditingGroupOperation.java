package by.itacademy.finalproject.menus.operable.edit;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menus.operable.Operable;
import by.itacademy.finalproject.menus.operable.edit.editing.ReflectiveEditor;
import by.itacademy.finalproject.menus.operable.edit.editing.perform.GroupEditPerform;

public class EditingGroupOperation implements Operable {
    private StringInput stringInput = new StringInput();
    private ReflectiveEditor<Group> editor = new ReflectiveEditor<>(new GroupEditPerform());
    private School school;

    public EditingGroupOperation(School school) {
        this.school = school;
    }

    @Override
    public void operate() {
        boolean term;
        do {
            printNames();
            String name = stringInput.getValue("Enter group name");
            Group group = school.getGroupByName(name);
            if (group == null) System.out.println("Group with name \"" + name + "\" was not found");
            else replaceGroup(group, editor.edit(new Group(group)));
            term = "Y".equalsIgnoreCase(stringInput.getValue("Want to edit another group? (Y/N)"));
        } while (term);
    }

    private void printNames() {
        for (Group group : school.getGroups()) {
            System.out.print(group.getName() + ", ");
        }
        System.out.println();
    }

    private void replaceGroup(Group oldGroup, Group newGroup) {
        if (newGroup != null) {
            school.removeGroup(oldGroup);
            if (school.containsGroup(newGroup)) {
                school.addGroup(oldGroup);
                System.out.println("Edited group overlap another group's schedule. Group edition was not saved.");
            } else {
                school.addGroup(newGroup);
                System.out.println("Group edition was saved.");
            }
        }
    }

    @Override
    public String typo() {
        return "Edit group in groups list";
    }
}
