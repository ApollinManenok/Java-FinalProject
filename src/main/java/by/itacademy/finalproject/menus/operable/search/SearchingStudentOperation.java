package by.itacademy.finalproject.menus.operable.search;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.menus.operable.Operable;
import by.itacademy.finalproject.menus.operable.search.searchable.Searchable;

import java.util.Set;

public class SearchingStudentOperation implements Operable {
    private Searchable searcher;
    private School school;

    public SearchingStudentOperation(School school, Searchable searcher) {
        this.searcher = searcher;
        this.school = school;
    }

    @Override
    public void operate() {
        searcher.setSearchingValue();
        Set<Student> studentsResult = searcher.search(school.getGroups());
        if (studentsResult.isEmpty()) System.out.println("Students was not found");
        else for (Student student : studentsResult)
            System.out.println(student);
    }

    @Override
    public String typo() {
        return searcher.typo();
    }
}
