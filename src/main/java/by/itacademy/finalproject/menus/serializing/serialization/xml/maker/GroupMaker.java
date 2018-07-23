package by.itacademy.finalproject.menus.serializing.serialization.xml.maker;

import by.itacademy.finalproject.domain.group.Classroom;
import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.domain.group.Teacher;
import by.itacademy.finalproject.domain.group.schedule.Schedule;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Set;

public class GroupMaker implements Maker<Group> {
    @Override
    public Group make(Node item) {
        NodeList items = item.getChildNodes();
        String name = items.item(1).getTextContent();
        Teacher teacher = new TeacherMaker().make(items.item(3));
        Classroom classroom = new ClassroomMaker().make(items.item(5));
        Schedule schedule = new SheduleMaker().make(items.item(7));
        Set<Student> students = new StudentsMaker().make(items.item(9).getChildNodes());
        return new Group(name, teacher, classroom, schedule, students);
    }
}
