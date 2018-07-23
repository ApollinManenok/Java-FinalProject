package by.itacademy.finalproject.menus.operable.review.reviewable.paid;

import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.menus.operable.review.reviewable.InfoMaker;
import by.itacademy.finalproject.menus.operable.review.reviewable.Reviewable;
import by.itacademy.finalproject.menus.operable.review.reviewable.paid.info.PaidInfo;
import by.itacademy.finalproject.menus.operable.review.reviewable.paid.info.PaidInfoMaker;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PaymentsReviewer implements Reviewable<PaidInfo> {
    private InfoMaker<PaidInfo, Student> infoGetter = new PaidInfoMaker();

    @Override
    public List<PaidInfo> review(Set<Group> groups) {
        List<PaidInfo> infos = new LinkedList<>();
        for (Group group : groups) {
            fill(group, infos);
        }

        return infos;
    }

    private void fill(Group group, List<PaidInfo> infos) {
        for (Student student : group.getStudents()) {
            infos.add(infoGetter.getInfo(student));
        }
    }

    @Override
    public String typo() {
        return "Print resent payments";
    }
}
