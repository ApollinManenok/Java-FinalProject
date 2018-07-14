package by.itacademy.finalproject.domain;


import by.itacademy.finalproject.inputable.IntegerInput;
import by.itacademy.finalproject.menuable.CriteriaSearchMenu;
import by.itacademy.finalproject.menuable.EditionMenu;
import by.itacademy.finalproject.menuable.Menuable;
import by.itacademy.finalproject.menuable.RangeException;
import by.itacademy.finalproject.menuable.SerializationMenu;

import java.util.ArrayList;

public class Administrator {
    private School school;
    private ArrayList<Menuable> menus = new ArrayList<>();

    public Administrator(School school) {
        this.school = school;
        menus.add(new EditionMenu(school));
        menus.add(new SerializationMenu(school));
        menus.add(new CriteriaSearchMenu(school));
    }

    public void chooseMenu() throws RangeException {
        boolean term = true;
        while (term) {
            System.out.println("Menu list:\n0. Exit\n1. Print Groups");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println(i + 2 + ". " + menus.get(i).typo());
            }
            int index = new IntegerInput().getValue("Enter menu number");
            term = operate(index);
        }
    }

    private boolean operate(int index) throws RangeException {
        if (index < 0 || index > this.menus.size() + 1)
            throw new RangeException("Index out of list range");
        else if (index == 0)
            return false;
        else if (index == 1) {
            System.out.println(school.getGroups());
            return true;
        }
        index -= 2;
        menus.get(index).list();
        return true;
    }
}
