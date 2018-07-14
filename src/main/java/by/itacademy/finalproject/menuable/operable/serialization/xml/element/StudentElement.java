package by.itacademy.finalproject.menuable.operable.serialization.xml.element;

import by.itacademy.finalproject.domain.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class StudentElement implements ElementCreator<Student> {
    private Document doc;

    public StudentElement(Document doc) {
        this.doc = doc;
    }

    public Element create(Student element) {
        Element docElement = doc.createElement("student");
        docElement.appendChild(execute("name", element.getName()));
        docElement.appendChild(execute("birthday", element.getBirthdayAsString()));
        docElement.appendChild(new PaymentsElement(doc).create(element.getPayments()));
        return docElement;
    }

    private Element execute(String tag, String value) {
        Element element = doc.createElement(tag);
        element.setTextContent(value);
        return element;
    }
}
