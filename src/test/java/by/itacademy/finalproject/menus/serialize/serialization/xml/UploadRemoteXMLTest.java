package by.itacademy.finalproject.menus.serialize.serialization.xml;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.Payment;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.menus.serializing.serialization.xml.UploadRemoteXML;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UploadRemoteXMLTest {
    private School school = new School("Start");
    private String source = "UploadRemoteXMLTestSchool.xml";
    private UploadRemoteXML uploader = new UploadRemoteXML(school, UploadRemoteXMLTest.class.getClassLoader().getResource(source));

    @Before
    public void readSchoolFromLocalJSON() {
        uploader.serialize();
    }

    @After
    public void clearSchoolGroups() {
        school.getGroups().clear();
    }

    @Test
    public void checkReadSchoolFromLocalJSONContainsGroupHigh() {
        boolean containsGroupHigh = school.containsGroupWithName("High");
        assertTrue(containsGroupHigh);
    }

    @Test
    public void checkReadingAddStudentsIfGroupsEquals() {
        Group testGroupHigh = school.getGroupByName("High");
        assertTrue(school.getGroups().contains(testGroupHigh));
        school.getGroups().clear();
        testGroupHigh.getStudents().clear();
        assertTrue(testGroupHigh.getStudents().isEmpty());
        school.addGroup(testGroupHigh);
        uploader.serialize();
        assertEquals(3, testGroupHigh.getStudents().size());
    }

    @Test
    public void checkGroupHighReadCorrectly() {
        Group groupForDeepChecking = school.getGroupByName("High");
        assertEquals("Helena Smith", groupForDeepChecking.getTeacher().getName());
        assertEquals(LocalDate.of(1993, 10, 13), groupForDeepChecking.getTeacher().getbDay());
        assertEquals("101", groupForDeepChecking.getClassroom().getName());
        assertEquals(1, groupForDeepChecking.getSchedule().getTimetable().size());
        assertEquals("Friday 10:30 - 12:30", groupForDeepChecking.getSchedule().getTimetableAsString());
        assertEquals(3, groupForDeepChecking.getStudents().size());
        Student student = groupForDeepChecking.getStudentByName("Jane Smith");
        assertEquals(LocalDate.of(1978, 10, 13), student.getbDay());
        assertEquals(2, student.getPayments().size());
        assertTrue(student.getPayments().contains(new Payment(LocalDate.of(2018, 7, 14), 50)));
        assertTrue(student.getPayments().contains(new Payment(LocalDate.of(2018, 6, 1), 50)));
    }
}
