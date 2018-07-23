package by.itacademy.finalproject.menus.operable.edit.creator;

import by.itacademy.finalproject.domain.group.Classroom;
import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.domain.group.StudentNameComparator;
import by.itacademy.finalproject.domain.group.Teacher;
import by.itacademy.finalproject.domain.group.schedule.Schedule;
import by.itacademy.finalproject.inputable.StringInput;

import java.util.Set;
import java.util.TreeSet;

public class GroupConsoleCreator implements ConsoleCreator<Group> {
    private StringInput stringInput = new StringInput();
    private TeacherConsoleCreator teacherCreator = new TeacherConsoleCreator();
    private ClassroomConsoleCreator classroomCreator = new ClassroomConsoleCreator();
    private ScheduleConsoleCreator scheduleCreator = new ScheduleConsoleCreator();
    private StudentConsoleCreator studentCreator = new StudentConsoleCreator();

    @Override
    public Group createInstance() {
        String name = stringInput.getValue("Enter group name");
        Teacher teacher = teacherCreator.createInstance();
        Classroom classroom = classroomCreator.createInstance();
        Schedule schedule = scheduleCreator.createInstance();
        Set<Student> students = getStudents();
        return new Group(name, teacher, classroom, schedule, students);
    }

    private Set<Student> getStudents() {
        Set<Student> temp = new TreeSet<>(new StudentNameComparator());
        boolean term;
        do {
            temp.add(studentCreator.createInstance());
            term = "Y".equalsIgnoreCase(stringInput.getValue("Do you want to add else student? (Y/N)"));
        } while (term);
        return temp;
    }
}
