package by.itacademy.finalproject.menuable;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.inputable.IntegerInput;
import by.itacademy.finalproject.menuable.operable.Operable;
import by.itacademy.finalproject.menuable.operable.edition.AddingGroupOperation;
import by.itacademy.finalproject.menuable.operable.edition.EditingGroupOperation;
import by.itacademy.finalproject.menuable.operable.edition.RemovingGroupOperation;

import java.util.ArrayList;

public class EditionMenu implements Menuable {
    private ArrayList<Operable> options = new ArrayList<>();

    public EditionMenu(School school) {
        options.add(new AddingGroupOperation(school.getGroups()));
        options.add(new RemovingGroupOperation(school.getGroups()));
        options.add(new EditingGroupOperation(school.getGroups()));
    }

    @Override
    public void list() throws RangeException {
        boolean term = true;
        while (term) {
            System.out.println("Menu list:\n0. Exit");
            for (int i = 0; i < options.size(); i++) {
                System.out.println(i + 1 + ". " + options.get(i).typo());
            }
            int index = new IntegerInput().getValue("Enter menu number");
            term = operate(index);
        }
    }

    private boolean operate(int index) throws RangeException {
        if (index < 0 || index > this.options.size())
            throw new RangeException("Index out of list range");
        else if (index == 0)
            return false;
        index -= 1;
        options.get(index).operate();
        return true;
    }

    @Override
    public String typo() {
        return "Editing school groups";
    }
}
