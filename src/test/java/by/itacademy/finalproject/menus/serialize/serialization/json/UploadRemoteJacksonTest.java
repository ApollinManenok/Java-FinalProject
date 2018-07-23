package by.itacademy.finalproject.menus.serialize.serialization.json;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.Payment;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.menus.serializing.serialization.json.UploadRemoteJackson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UploadRemoteJacksonTest {
    private School school = new School("Start");
    private String source = "UploadRemoteJacksonTestSchool.json";
    private UploadRemoteJackson uploader = new UploadRemoteJackson(school, UploadRemoteJacksonTest.class.getClassLoader().getResource(source));

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
        Student student = groupForDeepChecking.getStudentByName("Max Pain");
        assertEquals(LocalDate.of(1983, 7, 22), student.getbDay());
        assertEquals(2, student.getPayments().size());
        assertTrue(student.getPayments().contains(new Payment(LocalDate.of(2018, 7, 14), 50)));
        assertTrue(student.getPayments().contains(new Payment(LocalDate.of(2018, 5, 14), 50)));
    }
}
