package by.itacademy.finalproject.menuable.operable.edition;

import by.itacademy.finalproject.domain.Group;
import by.itacademy.finalproject.inputable.BooleanInput;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menuable.operable.Operable;

import java.util.Set;
import java.util.TreeSet;

public class RemovingGroupOperation implements Operable {
    private StringInput stringInput = new StringInput();
    private BooleanInput booleanInput = new BooleanInput();
    private Set<Group> groups;

    public RemovingGroupOperation(Set<Group> groups) {
        this.groups = groups;
    }

    @Override
    public void operate() {
        boolean term;
        Set<String> names = getNames();
        do {
            names.forEach(System.out::println);
            String name = stringInput.getValue("Enter group name");
            Group group = findGroupByName(name);
            if (group == null) System.out.println("Group with name \"" + name + "\" was not found");
            else groups.remove(group);
            term = booleanInput.getValue("Want to remove another group?");
        } while (term);
    }

    private Set<String> getNames() {
        Set<String> names = new TreeSet<>();
        for (Group group : groups) {
            names.add(group.getName());
        }
        return names;
    }

    private Group findGroupByName(String name) {
        for (Group group : groups) {
            if (group.getName().equals(name)) return group;
        }
        return null;
    }

    @Override
    public String typo() {
        return "Remove group from groups list";
    }
}
