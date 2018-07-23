package by.itacademy.finalproject.menus.operable.edit;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menus.operable.Operable;

public class RemovingGroupOperation implements Operable {
    private StringInput stringInput = new StringInput();
    private School school;

    public RemovingGroupOperation(School school) {
        this.school = school;
    }

    @Override
    public void operate() {
        boolean term;
        do {
            printNames();
            String name = stringInput.getValue("Enter group name");
            removeGroup(name);
            term = "Y".equalsIgnoreCase(stringInput.getValue("Want to remove another group? (Y/N)"));
        } while (term);
    }

    private void printNames() {
        for (Group group : school.getGroups()) {
            System.out.print(group.getName() + ", ");
        }
        System.out.println();
    }

    private void removeGroup(String name) {
        if (school.removeGroup(school.getGroupByName(name))) System.out.println("Group was removed");
        else System.out.println("Group with name \"" + name + "\" was not found");
    }

    @Override
    public String typo() {
        return "Remove group from groups list";
    }
}
