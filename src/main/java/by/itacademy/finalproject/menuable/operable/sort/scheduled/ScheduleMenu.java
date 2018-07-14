package by.itacademy.finalproject.menuable.operable.sort.scheduled;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.inputable.IntegerInput;
import by.itacademy.finalproject.menuable.Menuable;
import by.itacademy.finalproject.menuable.RangeException;
import by.itacademy.finalproject.menuable.operable.sort.scheduled.classroom.ClassroomSchedule;
import by.itacademy.finalproject.menuable.operable.sort.scheduled.group.GroupSchedule;
import by.itacademy.finalproject.menuable.operable.sort.scheduled.student.StudentSchedule;

import java.util.ArrayList;

public class ScheduleMenu implements Menuable {
    private School school;
    private ArrayList<Scheduled> options = new ArrayList<>();

    public ScheduleMenu(School school) {
        this.school = school;
        options.add(new GroupSchedule());
        options.add(new ClassroomSchedule());
        options.add(new StudentSchedule());
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
        options.get(index).scheduled(school.getGroups());
        return true;
    }


    @Override
    public String typo() {
        return "Search by criteria";
    }
}
