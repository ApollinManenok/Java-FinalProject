package by.itacademy.finalproject.menus.serialize.serialization.json;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.Payment;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.menus.serializing.serialization.json.ReadLocalGson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReadLocalGsonTest {
    private School school = new School("Start");
    private String testFile = "ReadLocalGsonTestSchool.json";
    private ReadLocalGson reader = new ReadLocalGson(school, new File(ReadLocalGsonTest.class.getClassLoader().getResource(testFile).getFile()));

    @Before
    public void readSchoolFromLocalJSON() {
        reader.serialize();
    }

    @After
    public void clearSchoolGroups() {
        school.getGroups().clear();
    }

    @Test
    public void checkRepeatingReadSchoolFromLocalJSONContainTwoGroups() {
        assertEquals(2, school.getGroups().size());
        reader.serialize();
        assertEquals(2, school.getGroups().size());
    }

    @Test
    public void checkReadSchoolFromLocalJSONContainsGroupsStarAndRose() {
        boolean containsGroupStar = school.containsGroupWithName("Star");
        boolean containsGroupRose = school.containsGroupWithName("Rose");
        assertTrue(containsGroupStar);
        assertTrue(containsGroupRose);
    }

    @Test
    public void checkReadingAddStudentsIfGroupsEquals() {
        Group testGroupStar = school.getGroupByName("Star");
        assertTrue(school.getGroups().contains(testGroupStar));
        school.getGroups().clear();
        testGroupStar.getStudents().clear();
        assertTrue(testGroupStar.getStudents().isEmpty());
        school.addGroup(testGroupStar);
        reader.serialize();
        assertEquals(3, testGroupStar.getStudents().size());
    }

    @Test
    public void checkGroupRoseReadCorrectly() {
        Group groupForDeepChecking = school.getGroupByName("Rose");
        assertEquals("Peter Parker", groupForDeepChecking.getTeacher().getName());
        assertEquals(LocalDate.of(1956, 9, 24), groupForDeepChecking.getTeacher().getbDay());
        assertEquals("100", groupForDeepChecking.getClassroom().getName());
        assertEquals(2, groupForDeepChecking.getSchedule().getTimetable().size());
        assertEquals("Monday 10:30 - 11:30, Wednesday 10:30 - 11:30", groupForDeepChecking.getSchedule().getTimetableAsString());
        assertEquals(1, groupForDeepChecking.getStudents().size());
        for (Student student : groupForDeepChecking.getStudents()) {
            assertEquals("Jane Smith", student.getName());
            assertEquals(LocalDate.of(1995, 10, 13), student.getbDay());
            assertEquals(2, student.getPayments().size());
            assertTrue(student.getPayments().contains(new Payment(LocalDate.of(2018, 2, 3), 150)));
            assertTrue(student.getPayments().contains(new Payment(LocalDate.of(2018, 4, 8), 150)));
        }
    }
}
