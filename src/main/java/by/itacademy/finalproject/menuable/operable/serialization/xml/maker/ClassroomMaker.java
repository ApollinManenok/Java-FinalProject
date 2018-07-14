package by.itacademy.finalproject.menuable.operable.serialization.xml.maker;

import by.itacademy.finalproject.domain.Classroom;
import org.w3c.dom.Node;

public class ClassroomMaker implements Maker<Classroom> {
    public Classroom make(Node item) {
        String name = item.getTextContent();
        return new Classroom(name);
    }
}
