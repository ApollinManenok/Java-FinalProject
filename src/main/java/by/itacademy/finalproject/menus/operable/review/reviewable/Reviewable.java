package by.itacademy.finalproject.menus.operable.review.reviewable;

import by.itacademy.finalproject.domain.group.Group;

import java.util.List;
import java.util.Set;

public interface Reviewable<T> {
    List<T> review(Set<Group> groups);

    String typo();
}
