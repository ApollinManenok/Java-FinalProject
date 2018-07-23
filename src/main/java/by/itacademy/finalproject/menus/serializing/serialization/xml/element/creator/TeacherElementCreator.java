package by.itacademy.finalproject.menus.serializing.serialization.xml.element.creator;

import by.itacademy.finalproject.domain.group.Teacher;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TeacherElementCreator implements ElementCreator<Teacher> {
    private Document doc;

    public TeacherElementCreator(Document doc) {
        this.doc = doc;
    }

    @Override
    public Element create(Teacher element) {
        Element docElement = doc.createElement("teacher");
        docElement.appendChild(execute("name", element.getName()));
        docElement.appendChild(execute("birthday", element.getBirthdayAsString()));
        return docElement;
    }

    private Element execute(String tag, String value) {
        Element element = doc.createElement(tag);
        element.setTextContent(value);
        return element;
    }
}
