package by.itacademy.finalproject.menus;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.inputable.IntegerInput;
import by.itacademy.finalproject.menus.operable.Operable;
import by.itacademy.finalproject.menus.operable.scheduler.ClassroomSchedulerOperation;
import by.itacademy.finalproject.menus.operable.scheduler.GroupSchedulerOperation;
import by.itacademy.finalproject.menus.operable.scheduler.StudentSchedulerOperation;
import by.itacademy.finalproject.menus.operable.scheduler.scheduled.classroom.ClassroomSchedule;
import by.itacademy.finalproject.menus.operable.scheduler.scheduled.classroom.ClassroomsSchedule;
import by.itacademy.finalproject.menus.operable.scheduler.scheduled.group.GroupSchedule;
import by.itacademy.finalproject.menus.operable.scheduler.scheduled.group.GroupsSchedule;
import by.itacademy.finalproject.menus.operable.scheduler.scheduled.student.StudentSchedule;
import by.itacademy.finalproject.menus.operable.scheduler.scheduled.student.StudentsSchedule;

import java.util.ArrayList;

public class SchedulerMenu implements Menuable {
    private ArrayList<Operable> options = new ArrayList<>();

    public SchedulerMenu(School school) {
        options.add(new GroupSchedulerOperation(school, new GroupSchedule()));
        options.add(new GroupSchedulerOperation(school, new GroupsSchedule()));
        options.add(new ClassroomSchedulerOperation(school, new ClassroomSchedule()));
        options.add(new ClassroomSchedulerOperation(school, new ClassroomsSchedule()));
        options.add(new StudentSchedulerOperation(school, new StudentSchedule()));
        options.add(new StudentSchedulerOperation(school, new StudentsSchedule()));
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
        return "Schedule menu";
    }
}
