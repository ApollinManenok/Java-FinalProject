package by.itacademy.finalproject.menus.operable.scheduler.scheduled.student;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.menus.serialize.serialization.json.ReadLocalGsonTest;
import by.itacademy.finalproject.menus.serializing.serialization.json.ReadLocalGson;
import org.junit.Test;

import java.io.File;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class StudentsScheduleTest {
    private StudentsSchedule scheduler = new StudentsSchedule();
    private School school = new School();
    private String fileName = "TestSchool.json";
    private ReadLocalGson reader = new ReadLocalGson(school, new File(ReadLocalGsonTest.class
            .getClassLoader().getResource(fileName).getFile()));

    @Test
    public void checkSchedulerFindAndComposeScheduleOfAllStudents() {
        reader.serialize();
        Map<String, Set<StudentInfo>> schedules = scheduler.compose(school.getGroups());
        assertEquals(6, schedules.size());
    }
}
