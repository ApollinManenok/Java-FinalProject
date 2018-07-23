package by.itacademy.finalproject.menus.serialize.serialization.xml;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.group.Classroom;
import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.Payment;
import by.itacademy.finalproject.domain.group.PaymentDateComparator;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.domain.group.StudentNameComparator;
import by.itacademy.finalproject.domain.group.Teacher;
import by.itacademy.finalproject.domain.group.schedule.Schedule;
import by.itacademy.finalproject.domain.group.schedule.TimeOrderException;
import by.itacademy.finalproject.domain.group.schedule.TimeOverlapException;
import by.itacademy.finalproject.domain.group.schedule.TimePeriod;
import by.itacademy.finalproject.menus.serializing.serialization.xml.ReadLocalXML;
import by.itacademy.finalproject.menus.serializing.serialization.xml.WriteLocalXML;
import org.junit.Test;

import java.io.File;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WriteLocalXMLTest {
    private School school = new School("Start");
    private String testFile = "WriteLocalXMLTestSchool.xml";
    private File file = new File(WriteLocalXMLTest.class.getClassLoader().getResource(testFile).getFile());
    private WriteLocalXML write = new WriteLocalXML(school, file);
    private ReadLocalXML read = new ReadLocalXML(school, file);

    @Test
    public void checkCorrectWritingGroupsInLocalXML() throws TimeOrderException, TimeOverlapException {
        Teacher teacher = new Teacher("Barbara Cross", LocalDate.of(1970, 7, 29));
        Classroom classroom = new Classroom("Sapphire");
        Schedule schedule = new Schedule();
        schedule.addTime(new TimePeriod(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 0)));
        Set<Student> students = new TreeSet<>(new StudentNameComparator());
        Set<Payment> payments = new TreeSet<>(new PaymentDateComparator());
        payments.add(new Payment(LocalDate.of(2018, 7, 20), 50));
        students.add(new Student("Jane Spell", LocalDate.of(1987, 8, 19), payments));
        students.add(new Student("Tomas Riddle", LocalDate.of(1900, 4, 14)));
        Group group = new Group("Stones", teacher, classroom, schedule, students);
        school.addGroup(group);
        write.serialize();
        school.clear();
        assertTrue(school.isEmpty());
        read.serialize();
        assertEquals(1, school.getGroups().size());
        assertTrue(school.containsGroup(group));
    }
}
