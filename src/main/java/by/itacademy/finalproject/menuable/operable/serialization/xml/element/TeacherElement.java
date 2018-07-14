package by.itacademy.finalproject.menuable.operable.serialization.xml.element;

import by.itacademy.finalproject.domain.Teacher;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TeacherElement implements ElementCreator<Teacher> {
    private Document doc;

    public TeacherElement(Document doc) {
        this.doc = doc;
    }

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
