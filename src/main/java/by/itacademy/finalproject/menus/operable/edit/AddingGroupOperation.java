package by.itacademy.finalproject.menus.operable.edit;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.menus.operable.Operable;
import by.itacademy.finalproject.menus.operable.edit.creator.GroupConsoleCreator;


public class AddingGroupOperation implements Operable {
    private GroupConsoleCreator creator = new GroupConsoleCreator();
    private School school;

    public AddingGroupOperation(School school) {
        this.school = school;
    }

    @Override
    public void operate() {
        Group group = creator.createInstance();
        if (group != null && !school.containsGroup(group)) {
            school.addGroup(group);
            System.out.println("Group was added");
        } else System.out.println("Group was not added");
    }

    @Override
    public String typo() {
        return "Adding group to groups list";
    }
}
