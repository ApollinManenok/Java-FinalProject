package by.itacademy.finalproject.menuable.operable.serialization.xml.element;

import by.itacademy.finalproject.domain.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.Set;

public class StudentsElement implements ElementCreator<Set<Student>> {
    private StudentElement creator;
    private Document doc;

    public StudentsElement(Document doc) {
        this.doc = doc;
        this.creator = new StudentElement(doc);
    }

    public Element create(Set<Student> studentSet) {
        Element students = doc.createElement("students");
        for (Student student : studentSet) {
            Element studentElement = creator.create(student);
            students.appendChild(studentElement);
        }
        return students;
    }
}
