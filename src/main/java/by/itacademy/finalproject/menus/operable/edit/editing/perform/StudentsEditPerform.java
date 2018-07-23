package by.itacademy.finalproject.menus.operable.edit.editing.perform;

import by.itacademy.finalproject.domain.group.FutureDateTimeException;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menus.operable.edit.creator.StudentConsoleCreator;
import by.itacademy.finalproject.menus.operable.edit.editing.Edit;
import by.itacademy.finalproject.menus.operable.edit.editing.EntityType;
import by.itacademy.finalproject.menus.operable.edit.editing.ReflectiveEditor;

import java.util.Set;

@EntityType(type = "students")
public class StudentsEditPerform implements EditPerform<Set<Student>> {
    private StringInput stringInput = new StringInput();
    private StudentConsoleCreator creator = new StudentConsoleCreator();
    private ReflectiveEditor<Student> editor = new ReflectiveEditor<>(new StudentEditPerform());

    @Edit(typo = "Add student into students list", name = "add")
    public boolean addStudent(Set<Student> students) throws FutureDateTimeException {
        Student student = creator.createInstance();
        if (!students.contains(student)) {
            students.add(student);
            return true;
        }
        System.out.println("Student already exist");
        return false;
    }

    @Edit(typo = "Change particular student in students list", name = "change")
    public boolean changeStudent(Set<Student> students) {
        Student student = findByName(students);
        if (student != null) {
            editor.edit(student);
            return true;
        }
        System.out.println("Student was not found");
        return false;
    }

    @Edit(typo = "Remove student from students list", name = "remove")
    public boolean removeStudent(Set<Student> students) {
        Student student = findByName(students);
        if (student != null) {
            students.remove(student);
            return true;
        }
        System.out.println("Student was not found");
        return false;
    }

    private Student findByName(Set<Student> students) {
        String name = stringInput.getValue("Enter student name");
        for (Student student : students) {
            if (student.getName().equals(name))
                return student;
        }
        return null;
    }
}
