package by.itacademy.finalproject.menus.serializing.serialization.xml.element.creator;

import by.itacademy.finalproject.domain.group.Group;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GroupElementCreator implements ElementCreator<Group> {
    private Document doc;

    public GroupElementCreator(Document doc) {
        this.doc = doc;
    }

    @Override
    public Element create(Group element) {
        Element docElement = doc.createElement("group");
        docElement.appendChild(execute("name", element.getName()));
        docElement.appendChild(new TeacherElementCreator(doc).create(element.getTeacher()));
        docElement.appendChild(execute("classroom", element.getClassroom().getName()));
        docElement.appendChild(execute("schedule", element.getSchedule().getTimetableAsString()));
        docElement.appendChild(new StudentsElementCreator(doc).create(element.getStudents()));
        return docElement;
    }

    private Element execute(String tag, String value) {
        Element element = doc.createElement(tag);
        element.setTextContent(value);
        return element;
    }
}
