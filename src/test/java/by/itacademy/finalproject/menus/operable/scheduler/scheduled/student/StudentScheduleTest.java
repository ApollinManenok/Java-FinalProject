package by.itacademy.finalproject.menus.operable.scheduler.scheduled.student;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.menus.serialize.serialization.json.ReadLocalGsonTest;
import by.itacademy.finalproject.menus.serializing.serialization.json.ReadLocalGson;
import org.junit.Test;

import java.io.File;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StudentScheduleTest {
    private StudentSchedule scheduler = new StudentSchedule();
    private School school = new School();
    private String fileName = "TestSchool.json";
    private ReadLocalGson reader = new ReadLocalGson(school, new File(ReadLocalGsonTest.class
            .getClassLoader().getResource(fileName).getFile()));

    {
        reader.serialize();
    }

    @Test
    public void checkSchedulerFindAndComposeScheduleOfStudentWithNameJaneCollins() {
        scheduler.setName("Jane Collins");
        Map<String, Set<StudentInfo>> schedules = scheduler.compose(school.getGroups());
        assertEquals(1, schedules.size());
        assertTrue(schedules.containsKey("Jane Collins"));
        assertEquals(1, schedules.get("Jane Collins").size());
    }

    @Test
    public void checkSchedulerFindAndComposeScheduleOfStudentWithNameJane() {
        scheduler.setName("Jane");
        Map<String, Set<StudentInfo>> schedules = scheduler.compose(school.getGroups());
        assertEquals(2, schedules.size());
        assertTrue(schedules.containsKey("Jane Collins"));
        assertEquals(1, schedules.get("Jane Collins").size());
        assertTrue(schedules.containsKey("Jane Smith"));
        assertEquals(3, schedules.get("Jane Smith").size());
    }

    @Test
    public void checkSchedulerDoesNotFindAndComposeScheduleOfStudentWithName_jane() {
        scheduler.setName("jane");
        Map<String, Set<StudentInfo>> schedules = scheduler.compose(school.getGroups());
        assertEquals(0, schedules.size());
    }
}
