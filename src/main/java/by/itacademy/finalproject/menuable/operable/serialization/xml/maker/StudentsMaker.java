package by.itacademy.finalproject.menuable.operable.serialization.xml.maker;

import by.itacademy.finalproject.domain.Payment;
import by.itacademy.finalproject.domain.Student;
import by.itacademy.finalproject.domain.formatter.DateTimeFormat;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class StudentsMaker implements MultyMaker<Set<Student>> {
    private PaymentsMaker maker = new PaymentsMaker();

    public Set<Student> make(NodeList item) {
        Set<Student> students = new HashSet<>();
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
