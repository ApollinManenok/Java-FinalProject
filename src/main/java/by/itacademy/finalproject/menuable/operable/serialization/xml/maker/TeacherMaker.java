package by.itacademy.finalproject.menuable.operable.serialization.xml.maker;

import by.itacademy.finalproject.domain.Teacher;
import by.itacademy.finalproject.domain.formatter.DateTimeFormat;
import org.w3c.dom.Node;

import java.time.LocalDate;

public class TeacherMaker implements Maker<Teacher> {
    public Teacher make(Node item) {
        String name = item.getChildNodes().item(1).getTextContent();
        LocalDate date = LocalDate.parse(item.getChildNodes().item(3).getTextContent(), DateTimeFormat.D_M_YYYY_DASH.getFormat());
        return new Teacher(name, date);
    }
}
