package by.itacademy.finalproject.menus.operable.review.reviewable.birthdays;

import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.domain.group.Teacher;
import by.itacademy.finalproject.menus.operable.review.reviewable.Reviewable;
import by.itacademy.finalproject.menus.operable.review.reviewable.birthdays.info.BirthdayInfo;
import by.itacademy.finalproject.menus.operable.review.reviewable.birthdays.info.BirthdayInfoComparator;
import by.itacademy.finalproject.menus.operable.review.reviewable.birthdays.info.BirthdayInfoMaker;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BirthdayReviewer implements Reviewable<BirthdayInfo> {
    private BirthdayInfoMaker<Teacher> teacherInfoMaker = new BirthdayInfoMaker<>();
    private BirthdayInfoMaker<Student> studentInfoMaker = new BirthdayInfoMaker<>();

    @Override
    public List<BirthdayInfo> review(Set<Group> groups) {
        List<BirthdayInfo> infos = new LinkedList<>();
        for (Group group : groups) {
            fill(group, infos);
        }
        infos.sort(new BirthdayInfoComparator());
        return infos;
    }

    public void fill(Group group, List<BirthdayInfo> infos) {
        infos.add(teacherInfoMaker.getInfo(group.getTeacher()));
        for (Student student : group.getStudents()) {
            infos.add(studentInfoMaker.getInfo(student));
        }
    }

    public String typo() {
        return "Print all birthday dates";
    }
}
