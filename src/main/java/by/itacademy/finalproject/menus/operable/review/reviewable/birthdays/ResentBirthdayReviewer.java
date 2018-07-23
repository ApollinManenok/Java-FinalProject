package by.itacademy.finalproject.menus.operable.review.reviewable.birthdays;

import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.domain.group.Teacher;
import by.itacademy.finalproject.menus.operable.review.reviewable.InfoMaker;
import by.itacademy.finalproject.menus.operable.review.reviewable.Reviewable;
import by.itacademy.finalproject.menus.operable.review.reviewable.birthdays.info.BirthdayInfo;
import by.itacademy.finalproject.menus.operable.review.reviewable.birthdays.info.BirthdayInfoComparator;
import by.itacademy.finalproject.menus.operable.review.reviewable.birthdays.info.BirthdayInfoMaker;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ResentBirthdayReviewer implements Reviewable<BirthdayInfo> {
    private InfoMaker<BirthdayInfo, Teacher> teacherInfoMaker = new BirthdayInfoMaker<>();
    private InfoMaker<BirthdayInfo, Student> studentInfoMaker = new BirthdayInfoMaker<>();

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
        checkedAdd(infos, teacherInfoMaker.getInfo(group.getTeacher()));
        for (Student student : group.getStudents()) {
            checkedAdd(infos, studentInfoMaker.getInfo(student));
        }
    }

    private void checkedAdd(List<BirthdayInfo> infos, BirthdayInfo info) {
        int yearDay = info.getDate().getDayOfYear();
        int lowerBound = LocalDate.now().withDayOfMonth(1).getDayOfYear();
        int upperBound = LocalDate.now().withDayOfMonth(1).plusMonths(2).getDayOfYear();
        if (yearDay >= lowerBound && yearDay <= upperBound)
            infos.add(info);
    }

    public String typo() {
        return "Print closest birthday dates";
    }
}
