package by.itacademy.finalproject.domain;


import by.itacademy.finalproject.inputable.IntegerInput;
import by.itacademy.finalproject.menus.EditMenu;
import by.itacademy.finalproject.menus.Menuable;
import by.itacademy.finalproject.menus.RangeException;
import by.itacademy.finalproject.menus.ReviewMenu;
import by.itacademy.finalproject.menus.SchedulerMenu;
import by.itacademy.finalproject.menus.SearchMenu;
import by.itacademy.finalproject.menus.serializing.SerializationMenu;

import java.util.ArrayList;

public class Administrator implements Menuable {
    private School school;
    private ArrayList<Menuable> menus = new ArrayList<>();

    public Administrator(School school) {
        this.school = school;
        menus.add(new EditMenu(school));
        menus.add(new SearchMenu(school));
        menus.add(new SchedulerMenu(school));
        menus.add(new ReviewMenu(school));
        menus.add(new SerializationMenu(school));
    }

    @Override
    public void list() throws RangeException {
        boolean term = true;
        while (term) {
            System.out.println("Menu list:\n0. Exit\n1. Print Groups");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println(i + 2 + ". " + menus.get(i).typo());
            }
            int index = new IntegerInput().getValue("Enter menu number");
            term = delegate(index);
        }
    }

    private boolean delegate(int index) throws RangeException {
        if (index < 0 || index > this.menus.size() + 1) throw new RangeException("Index out of list range");
        else if (index == 0) return false;
        else if (index == 1) {
            System.out.print(school.getGroupsAsString());
            return true;
        }
        index -= 2;
        menus.get(index).list();
        return true;
    }

    @Override
    public String typo() {
        return "Administrator";
    }
}
