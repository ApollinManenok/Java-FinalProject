package by.itacademy.finalproject.menuable.operable.sort.birthdays;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.inputable.IntegerInput;
import by.itacademy.finalproject.menuable.Menuable;
import by.itacademy.finalproject.menuable.RangeException;

public class BirthdayGuysMenu implements Menuable {
    private BirthdaySchedule schedule = new BirthdaySchedule();
    private School school;

    public BirthdayGuysMenu(School school) {
        this.school = school;
    }

    @Override
    public void list() throws RangeException {
        boolean term = true;
        while (term) {
            System.out.println("Menu list:\n0. Exit");
            System.out.println("1. " + schedule.typo());
            int index = new IntegerInput().getValue("Enter menu number");
            term = operate(index);
        }
    }

    private boolean operate(int index) throws RangeException {
        if (index < 0 || index > 1)
            throw new RangeException("Index out of list range");
        else if (index == 0)
            return false;
        schedule.showBirthdays(school.getGroups());
        return true;
    }

    @Override
    public String typo() {
        return "Search by criteria";
    }
}
