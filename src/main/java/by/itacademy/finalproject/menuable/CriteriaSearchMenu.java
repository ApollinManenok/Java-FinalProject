package by.itacademy.finalproject.menuable;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.inputable.IntegerInput;
import by.itacademy.finalproject.menuable.operable.sort.showable.birthdays.BirthdayGuysMenu;
import by.itacademy.finalproject.menuable.operable.sort.scheduled.ScheduleMenu;

import java.util.ArrayList;

public class CriteriaSearchMenu implements Menuable {
    private ArrayList<Menuable> options = new ArrayList<>();

    public CriteriaSearchMenu(School school) {
        options.add(new ScheduleMenu(school));
        //options.add(StudentSearch(4 criteria))find student(s) name, age, group name, teacher name
        options.add(new BirthdayGuysMenu(school));
        //options.add(2)find payments this, next month, find losers
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
        return "Search by criteria";
    }
}
