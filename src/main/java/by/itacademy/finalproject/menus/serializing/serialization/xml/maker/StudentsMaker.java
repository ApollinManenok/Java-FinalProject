package by.itacademy.finalproject.menus.serializing.serialization.xml.maker;

import by.itacademy.finalproject.domain.group.Payment;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.domain.group.StudentNameComparator;
import by.itacademy.finalproject.domain.group.formatter.DateTimeFormat;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class StudentsMaker implements MultyMaker<Set<Student>> {
    private PaymentsMaker maker = new PaymentsMaker();

    @Override
    public Set<Student> make(NodeList item) {
        Set<Student> students = new TreeSet<>(new StudentNameComparator());
        for (int i = 1; i < item.getLength(); i += 2) {
            students.add(makeStudent(item.item(i)));
        }
        return students;
    }

    private Student makeStudent(Node item) {
        String name = item.getChildNodes().item(1).getTextContent();
        LocalDate date = LocalDate.parse(item.getChildNodes().item(3).getTextContent(), DateTimeFormat.D_M_YYYY_DASH.getFormat());
        Set<Payment> payments = maker.make(item.getChildNodes().item(5).getChildNodes());
        return new Student(name, date, payments);
    }
}
