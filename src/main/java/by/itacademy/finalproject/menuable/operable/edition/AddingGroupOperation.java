package by.itacademy.finalproject.menuable.operable.edition;

import by.itacademy.finalproject.domain.Group;
import by.itacademy.finalproject.menuable.operable.Operable;
import by.itacademy.finalproject.menuable.operable.edition.create.GroupConsoleCreator;

import java.util.Set;


public class AddingGroupOperation implements Operable {
    private Set<Group> groups;
    private GroupConsoleCreator creator = new GroupConsoleCreator();

    public AddingGroupOperation(Set<Group> groups) {
        this.groups = groups;
    }

    @Override
    public void operate() {
        Group group = creator.createInstance();
        if (!groups.contains(group)) {
            groups.add(group);
            System.out.println("Group was added");
        } else System.out.println("Group overlap another groups");
    }

    @Override
    public String typo() {
        return "Adding group to groups list";
    }
}
