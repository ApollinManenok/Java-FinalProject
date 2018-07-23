package by.itacademy.finalproject.menus.serializing.serialization.xml.maker;

import by.itacademy.finalproject.domain.group.Classroom;
import org.w3c.dom.Node;

public class ClassroomMaker implements Maker<Classroom> {
    @Override
    public Classroom make(Node item) {
        String name = item.getTextContent();
        return new Classroom(name);
    }
}
