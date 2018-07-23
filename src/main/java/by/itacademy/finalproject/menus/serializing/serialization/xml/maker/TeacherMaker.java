package by.itacademy.finalproject.menus.serializing.serialization.xml.maker;

import by.itacademy.finalproject.domain.group.FutureDateTimeException;
import by.itacademy.finalproject.domain.group.Teacher;
import by.itacademy.finalproject.domain.group.formatter.DateTimeFormat;
import org.w3c.dom.Node;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherMaker implements Maker<Teacher> {
    private static final Logger LOGGER = Logger.getLogger(TeacherMaker.class.getName());

    @Override
    public Teacher make(Node item) {
        String name = item.getChildNodes().item(1).getTextContent();
        LocalDate date = LocalDate.parse(item.getChildNodes().item(3).getTextContent(), DateTimeFormat.D_M_YYYY_DASH.getFormat());
        Teacher teacher = null;
        try {
            teacher = new Teacher(name, date);
        } catch (FutureDateTimeException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
        return teacher;
    }
}
