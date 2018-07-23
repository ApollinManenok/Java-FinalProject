package by.itacademy.finalproject.menus.operable.search.searchable;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.menus.serialize.serialization.json.ReadLocalGsonTest;
import by.itacademy.finalproject.menus.serializing.serialization.json.ReadLocalGson;
import org.junit.Test;

import java.io.File;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GroupSearchTest {
    private GroupSearch searcher = new GroupSearch();
    private School school = new School();
    private String fileName = "TestSchool.json";
    private ReadLocalGson reader = new ReadLocalGson(school, new File(ReadLocalGsonTest.class
            .getClassLoader().getResource(fileName).getFile()));

    {
        reader.serialize();
    }

    @Test
    public void checkSearcherFindStudentsFromGroupWithNameRose() {
        searcher.setName("Rose");
        Set<Student> students = searcher.search(school.getGroups());
        assertEquals(1, students.size());
    }

    @Test
    public void checkSearcherFindStudentsFromGroupWithNameStar() {
        Set<Student> correctStudents = school.getGroupByName("Star").getStudents();
        searcher.setName("Star");
        Set<Student> students = searcher.search(school.getGroups());
        assertEquals(3, students.size());
        for (Student student : correctStudents) {
            assertTrue(students.contains(student));
        }
    }

    @Test
    public void checkSearcherDoesNotFindStudentsFromGroupWithNameRock() {
        searcher.setName("Rock");
        Set<Student> students = searcher.search(school.getGroups());
        assertEquals(0, students.size());
    }
}
