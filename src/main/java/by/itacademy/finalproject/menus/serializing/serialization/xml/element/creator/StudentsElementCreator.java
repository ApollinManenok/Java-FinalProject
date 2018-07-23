package by.itacademy.finalproject.menus.serializing.serialization.xml.element.creator;

import by.itacademy.finalproject.domain.group.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.Set;

public class StudentsElementCreator implements ElementCreator<Set<Student>> {
    private StudentElementCreator creator;
    private Document doc;

    public StudentsElementCreator(Document doc) {
        this.doc = doc;
        this.creator = new StudentElementCreator(doc);
    }

    @Override
    public Element create(Set<Student> studentSet) {
        Element students = doc.createElement("students");
        for (Student student : studentSet) {
            Element studentElement = creator.create(student);
            students.appendChild(studentElement);
        }
        return students;
    }
}
