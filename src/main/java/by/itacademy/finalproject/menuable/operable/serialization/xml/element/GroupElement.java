package by.itacademy.finalproject.menuable.operable.serialization.xml.element;

import by.itacademy.finalproject.domain.Group;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GroupElement implements ElementCreator<Group> {
    private Document doc;

    public GroupElement(Document doc) {
        this.doc = doc;
    }

    public Element create(Group element) {
        Element docElement = doc.createElement("group");
        docElement.appendChild(execute("name", element.getName()));
        docElement.appendChild(new TeacherElement(doc).create(element.getTeacher()));
        docElement.appendChild(execute("classroom", element.getClassroom().getName()));
        docElement.appendChild(execute("scheduled", element.getSchedule().getTimetableAsString()));
        docElement.appendChild(new StudentsElement(doc).create(element.getStudents()));
        return docElement;
    }

    private Element execute(String tag, String value) {
        Element element = doc.createElement(tag);
        element.setTextContent(value);
        return element;
    }
}
