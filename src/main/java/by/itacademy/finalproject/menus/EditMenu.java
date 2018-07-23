package by.itacademy.finalproject.menus;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.inputable.IntegerInput;
import by.itacademy.finalproject.menus.operable.Operable;
import by.itacademy.finalproject.menus.operable.edit.AddingGroupOperation;
import by.itacademy.finalproject.menus.operable.edit.EditingGroupOperation;
import by.itacademy.finalproject.menus.operable.edit.RemovingGroupOperation;

import java.util.ArrayList;

public class EditMenu implements Menuable {
    private ArrayList<Operable> options = new ArrayList<>();

    public EditMenu(School school) {
        options.add(new AddingGroupOperation(school));
        options.add(new RemovingGroupOperation(school));
        options.add(new EditingGroupOperation(school));
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
