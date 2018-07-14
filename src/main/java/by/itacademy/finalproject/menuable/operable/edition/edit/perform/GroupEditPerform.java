package by.itacademy.finalproject.menuable.operable.edition.edit.perform;

import by.itacademy.finalproject.domain.Classroom;
import by.itacademy.finalproject.domain.Group;
import by.itacademy.finalproject.domain.Student;
import by.itacademy.finalproject.domain.Teacher;
import by.itacademy.finalproject.domain.schedule.Schedule;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menuable.operable.edition.edit.Edit;
import by.itacademy.finalproject.menuable.operable.edition.edit.EntityType;
import by.itacademy.finalproject.menuable.operable.edition.edit.ReflectiveEditor;

import java.util.HashSet;
import java.util.Set;

@EntityType(type = "group")
public class GroupEditPerform implements EditPerform<Group> {
    @Edit(typo = "Change group's name", name = "name")
    public boolean editName(Group group) {
        System.out.println("Group current name \"" + group.getName() + "\"");
        String newName = new StringInput().getValue("Enter new name");
        if (!group.getName().equals(newName)) {
            group.setName(newName);
            return true;
        }
        return false;
    }

    @Edit(typo = "Change group's teacher", name = "teacher")
    public boolean editTeacher(Group group) {
        Teacher teacher = new ReflectiveEditor<>(new TeacherEditPerform()).operate(new Teacher(group.getTeacher()));
        if (!group.getTeacher().equals(teacher) && teacher != null) {
            group.setTeacher(teacher);
            return true;
        }
        return false;
    }

    @Edit(typo = "Change group's classroom", name = "classroom")
    public boolean editClassroom(Group group) {
        Classroom classroom = new ReflectiveEditor<>(new ClassroomEditPerform()).operate(new Classroom(group.getClassroom()));
        if (!group.getClassroom().equals(classroom) && classroom != null) {
            group.setClassroom(classroom);
            return true;
        }
        return false;
    }

    @Edit(typo = "Change group's scheduled", name = "scheduled")
    public boolean editSchedule(Group group) {
        Schedule schedule = new ReflectiveEditor<>(new ScheduleEditPerform()).operate(new Schedule(group.getSchedule()));
        if (!group.getSchedule().equals(schedule) && schedule != null) {
            group.setSchedule(schedule);
            return true;
        }
        return false;
    }

    @Edit(typo = "Change group's student list", name = "students")
    public boolean editStudents(Group group) {
        Set<Student> students = new ReflectiveEditor<>(new StudentsEditPerform()).operate(new HashSet<>(group.getStudents()));
        if (students != null) {
            group.getStudents().clear();
            group.getStudents().addAll(students);
            return true;
        }
        return false;
    }
}