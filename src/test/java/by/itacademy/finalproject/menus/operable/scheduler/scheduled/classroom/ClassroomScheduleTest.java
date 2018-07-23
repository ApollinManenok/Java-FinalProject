package by.itacademy.finalproject.menus.operable.scheduler.scheduled.classroom;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.menus.serialize.serialization.json.ReadLocalGsonTest;
import by.itacademy.finalproject.menus.serializing.serialization.json.ReadLocalGson;
import org.junit.Test;

import java.io.File;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClassroomScheduleTest {
    private ClassroomSchedule scheduler = new ClassroomSchedule();
    private School school = new School();
    private String fileName = "TestSchool.json";
    private ReadLocalGson reader = new ReadLocalGson(school, new File(ReadLocalGsonTest.class
            .getClassLoader().getResource(fileName).getFile()));

    {
        reader.serialize();
    }

    @Test
    public void checkSchedulerFindAndComposeScheduleOfClassroomWithName100() {
        scheduler.setClassroomName("100");
        Map<String, Set<ClassroomInfo>> schedules = scheduler.compose(school.getGroups());
        assertEquals(1, schedules.size());
        assertTrue(schedules.containsKey("100"));
        assertEquals(3, schedules.get("100").size());
    }

    @Test
    public void checkSchedulerFindAndComposeScheduleOfClassroomWithName101() {
        scheduler.setClassroomName("101");
        Map<String, Set<ClassroomInfo>> schedules = scheduler.compose(school.getGroups());
        assertEquals(1, schedules.size());
        assertTrue(schedules.containsKey("101"));
        assertEquals(1, schedules.get("101").size());
    }

    @Test
    public void checkSchedulerDoesNotFindAndComposeScheduleOfClassroomWithName1() {
        scheduler.setClassroomName("1");
        Map<String, Set<ClassroomInfo>> schedules = scheduler.compose(school.getGroups());
        assertEquals(0, schedules.size());
    }
}
