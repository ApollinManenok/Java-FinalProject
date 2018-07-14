package by.itacademy.finalproject.menuable.operable.edition;

import by.itacademy.finalproject.domain.Group;
import by.itacademy.finalproject.inputable.BooleanInput;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menuable.operable.Operable;
import by.itacademy.finalproject.menuable.operable.edition.edit.ReflectiveEditor;
import by.itacademy.finalproject.menuable.operable.edition.edit.perform.GroupEditPerform;

import java.util.Set;
import java.util.TreeSet;

public class EditingGroupOperation implements Operable {
    private StringInput stringInput = new StringInput();
    private BooleanInput booleanInput = new BooleanInput();
    private ReflectiveEditor<Group> editor = new ReflectiveEditor<>(new GroupEditPerform());
    private Set<Group> groups;

    public EditingGroupOperation(Set<Group> groups) {
        this.groups = groups;
    }

    @Override
    public void operate() {
        boolean term;
        Set<String> names = getNames();
        do {
            names.forEach(System.out::print);
            String name = stringInput.getValue("Enter group name");
            Group group = findGroupByName(name);
            Group temp = null;
            if (group == null) System.out.println("Group with name \"" + name + "\" was not found");
            else temp = editor.operate(new Group(group));
            replaceGroup(group, temp);
            term = booleanInput.getValue("Want to edit another group?");
        } while (term);
    }

    private Set<String> getNames() {
        Set<String> names = new TreeSet<>();
        for (Group group : groups) {
            names.add(group.getName() + " ");
        }
        return names;
    }

    private Group findGroupByName(String name) {
        for (Group group : groups) {
            if (group.getName().equals(name)) return group;
        }
        return null;
    }

    private void replaceGroup(Group oldGroup, Group newGroup) {
        if (newGroup != null) {
            groups.remove(oldGroup);
            if (groups.contains(newGroup)) {
                groups.add(oldGroup);
                System.out.println("Edited group overlap another group's scheduled. Group edition was not saved.");
            } else {
                groups.add(newGroup);
                System.out.println("Group edition was saved.");
            }
        }
    }

    @Override
    public String typo() {
        return "Edit group in groups list";
    }
}
