package by.itacademy.finalproject.menus.operable.search.searchable;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.menus.serialize.serialization.json.ReadLocalGsonTest;
import by.itacademy.finalproject.menus.serializing.serialization.json.ReadLocalGson;
import org.junit.Test;

import java.io.File;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class NameSearchTest {
    private NameSearch searcher = new NameSearch();
    private School school = new School();
    private String fileName = "TestSchool.json";
    private ReadLocalGson reader = new ReadLocalGson(school, new File(ReadLocalGsonTest.class
            .getClassLoader().getResource(fileName).getFile()));

    {
        reader.serialize();
    }

    @Test
    public void checkSearcherFindStudentWithNameJaneCollins() {
        searcher.setName("Jane Collins");
        Set<Student> students = searcher.search(school.getGroups());
        assertEquals(1, students.size());
    }

    @Test
    public void checkSearcherFindStudentsWithNameJane() {
        searcher.setName("Jane");
        Set<Student> students = searcher.search(school.getGroups());
        assertEquals(3, students.size());
    }

    @Test
    public void checkSearcherFindStudentsWithNameJ() {
        searcher.setName("J");
        Set<Student> students = searcher.search(school.getGroups());
        assertEquals(3, students.size());
    }

    @Test
    public void checkSearcherDoesNotFindStudentWithName_jane() {
        searcher.setName("jane");
        Set<Student> students = searcher.search(school.getGroups());
        assertEquals(0, students.size());
    }
}
