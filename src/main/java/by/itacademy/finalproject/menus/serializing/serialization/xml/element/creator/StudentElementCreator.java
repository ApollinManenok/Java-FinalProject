package by.itacademy.finalproject.menus.serializing.serialization.xml.element.creator;

import by.itacademy.finalproject.domain.group.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class StudentElementCreator implements ElementCreator<Student> {
    private Document doc;

    public StudentElementCreator(Document doc) {
        this.doc = doc;
    }

    @Override
    public Element create(Student element) {
        Element docElement = doc.createElement("student");
        docElement.appendChild(execute("name", element.getName()));
        docElement.appendChild(execute("birthday", element.getBirthdayAsString()));
        docElement.appendChild(new PaymentsElementCreator(doc).create(element.getPayments()));
        return docElement;
    }

    private Element execute(String tag, String value) {
        Element element = doc.createElement(tag);
        element.setTextContent(value);
        return element;
    }
}
