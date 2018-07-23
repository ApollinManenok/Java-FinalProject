package by.itacademy.finalproject.menus.serializing;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.inputable.IntegerInput;
import by.itacademy.finalproject.menus.Menuable;
import by.itacademy.finalproject.menus.RangeException;

import java.util.ArrayList;

public class SerializationMenu implements Menuable {
    private ArrayList<Menuable> options = new ArrayList<>();

    public SerializationMenu(School school) {
        options.add(new XMLSerializationMenu(school));
        options.add(new JSONSerializationMenu(school));
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
        options.get(index).list();
        return true;
    }

    @Override
    public String typo() {
        return "Serialize groups";
    }
}
