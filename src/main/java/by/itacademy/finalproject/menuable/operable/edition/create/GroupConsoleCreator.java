package by.itacademy.finalproject.menuable.operable.edition.create;

import by.itacademy.finalproject.domain.*;
import by.itacademy.finalproject.domain.schedule.Schedule;
import by.itacademy.finalproject.inputable.StringInput;

import java.util.HashSet;
import java.util.Set;

public class GroupConsoleCreator implements ConsoleCreator<Group> {
    private StringInput stringInput = new StringInput();
    private TeacherConsoleCreator teacherCreator = new TeacherConsoleCreator();
    private ClassroomConsoleCreator classroomCreator = new ClassroomConsoleCreator();
    private ScheduleConsoleCreator scheduleCreator = new ScheduleConsoleCreator();
    private StudentConsoleCreator studentCreator = new StudentConsoleCreator();

    public Group createInstance() throws FutureDateTimeException {
        String name = stringInput.getValue("Enter group name");
        Teacher teacher = teacherCreator.createInstance();
        Classroom classroom = classroomCreator.createInstance();
        Schedule schedule = scheduleCreator.createInstance();
        Set<Student> students = getStudents();
        return new Group(name, teacher, classroom, schedule, students);
    }

    private Set<Student> getStudents() throws FutureDateTimeException {
        Set<Student> temp = new HashSet<>();
        boolean term;
        do {
            temp.add(studentCreator.createInstance());
            term = "Y".equalsIgnoreCase(stringInput.getValue("Do you want to add else student? (Y/N)"));
        } while (term);
        return temp;
    }
}
