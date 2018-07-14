package by.itacademy.finalproject.menuable.operable.sort.showable.paid;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.inputable.IntegerInput;
import by.itacademy.finalproject.menuable.Menuable;
import by.itacademy.finalproject.menuable.RangeException;

public class PaidMenu implements Menuable {
    private PaidSchedule payments = new PaidSchedule();
    private School school;

    public PaidMenu(School school) {
        this.school = school;
    }

    @Override
    public void list() throws RangeException {
        boolean term = true;
        while (term) {
            System.out.println("Menu list:\n0. Exit");
            System.out.println("1. " + payments.typo());
            int index = new IntegerInput().getValue("Enter menu number");
            term = operate(index);
        }
    }

    private boolean operate(int index) throws RangeException {
        if (index < 0 || index > 1)
            throw new RangeException("Index out of list range");
        else if (index == 0)
            return false;
        payments.showPaid(school.getGroups());
        return true;
    }

    @Override
    public String typo() {
        return "Search by criteria";
    }
