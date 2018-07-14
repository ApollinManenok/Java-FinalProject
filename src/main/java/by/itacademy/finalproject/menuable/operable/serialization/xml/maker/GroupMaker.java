package by.itacademy.finalproject.menuable.operable.serialization.xml.maker;

import by.itacademy.finalproject.domain.Classroom;
import by.itacademy.finalproject.domain.Group;
import by.itacademy.finalproject.domain.Student;
import by.itacademy.finalproject.domain.Teacher;
import by.itacademy.finalproject.domain.schedule.Schedule;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Set;

public class GroupMaker implements Maker<Group> {
    public Group make(Node item) {
        NodeList items = item.getChildNodes();
        String name = makeName(items.item(1));
        Teacher teacher = new TeacherMaker().make(items.item(3));
        Classroom classroom = new ClassroomMaker().make(items.item(5));
        Schedule schedule = new SheduleMaker().make(items.item(7));
        Set<Student> students = new StudentsMaker().make(items.item(9).getChildNodes());
        return new Group(name, teacher, classroom, schedule, students);
    }

    private String makeName(Node item) {
        return item.getTextContent();
    }
}
