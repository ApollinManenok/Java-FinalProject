package by.itacademy.finalproject.menus;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.inputable.IntegerInput;
import by.itacademy.finalproject.menus.operable.Operable;
import by.itacademy.finalproject.menus.operable.search.SearchingStudentOperation;
import by.itacademy.finalproject.menus.operable.search.searchable.AgeSearch;
import by.itacademy.finalproject.menus.operable.search.searchable.GroupSearch;
import by.itacademy.finalproject.menus.operable.search.searchable.NameSearch;
import by.itacademy.finalproject.menus.operable.search.searchable.TeacherSearch;

import java.util.ArrayList;

public class SearchMenu implements Menuable {
    private ArrayList<Operable> options = new ArrayList<>();

    public SearchMenu(School school) {
        options.add(new SearchingStudentOperation(school, new NameSearch()));
        options.add(new SearchingStudentOperation(school, new AgeSearch()));
        options.add(new SearchingStudentOperation(school, new GroupSearch()));
        options.add(new SearchingStudentOperation(school, new TeacherSearch()));
    }

    @Override
    public void list() throws RangeException {
        boolean term = true;
        while (term) {
            System.out.println("Menu list:\n0. Exit");
            for (int i = 0; i < options.size(); i++) {
                System.out.println(i + 1 + ". " + options.get(i).typo());
            }
            int index = new IntegerInput().getValue("Enter menu number");
            term = operate(index);
        }
    }

    private boolean operate(int index) throws RangeException {
        if (index < 0 || index > this.options.size())
            throw new RangeException("Index out of list range");
        else if (index == 0)
            return false;
        index -= 1;
        options.get(index).operate();
        return true;
    }

    @Override
    public String typo() {
        return "Search student by criteria";
    }
}
