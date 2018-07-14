package by.itacademy.finalproject.menuable.operable.edition.edit.perform;

import by.itacademy.finalproject.domain.Student;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menuable.operable.edition.create.StudentConsoleCreator;
import by.itacademy.finalproject.menuable.operable.edition.edit.Edit;
import by.itacademy.finalproject.menuable.operable.edition.edit.EntityType;
import by.itacademy.finalproject.menuable.operable.edition.edit.ReflectiveEditor;

import java.util.Set;

@EntityType(type = "students")
public class StudentsEditPerform implements EditPerform<Set<Student>> {
    private StringInput stringInput = new StringInput();
    private StudentConsoleCreator creator = new StudentConsoleCreator();
    private ReflectiveEditor<Student> editor = new ReflectiveEditor<>(new StudentEditPerform());

    @Edit(typo = "Add student into students list", name = "add")
    public boolean addStudent(Set<Student> students) {
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
            editor.operate(student);
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
