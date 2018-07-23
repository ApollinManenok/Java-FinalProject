package by.itacademy.finalproject.menus.operable.search.searchable;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.menus.serialize.serialization.json.ReadLocalGsonTest;
import by.itacademy.finalproject.menus.serializing.serialization.json.ReadLocalGson;
import org.junit.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AgeSearchTest {
    private AgeSearch searcher = new AgeSearch();
    private School school = new School();
    private String fileName = "TestSchool.json";
    private ReadLocalGson reader = new ReadLocalGson(school, new File(ReadLocalGsonTest.class
            .getClassLoader().getResource(fileName).getFile()));

    {
        reader.serialize();
    }

    @Test
    public void checkSearcherFindAtLeastOneStudentWithJaneSmithCountedAge() throws NegativeAgeException {
        Student JaneSmith = school.getGroupByName("Rose").getStudentByName("Jane Smith");
        int age = JaneSmith.getbDay().getYear();
        if (LocalDate.now().getDayOfYear() < JaneSmith.getbDay().getDayOfYear()) age -= 1;
        searcher.setAge(age);
        Set<Student> students = searcher.search(school.getGroups());
        assertEquals(0, students.size());
    }

    @Test
    public void checkSearcherDoesNotFindStudentWithAge1() throws NegativeAgeException {
        searcher.setAge(1);
        Set<Student> students = searcher.search(school.getGroups());
        assertTrue(students.isEmpty());
    }

    @Test(expected = NegativeAgeException.class)
    public void checkSearcherThrowExceptionWithAge0() throws NegativeAgeException {
        searcher.setAge(0);
    }
}
