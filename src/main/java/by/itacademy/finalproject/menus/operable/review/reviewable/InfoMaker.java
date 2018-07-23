package by.itacademy.finalproject.menus.operable.review.reviewable;

import by.itacademy.finalproject.domain.group.Student;

public interface InfoMaker<T, K> {
    T getInfo(K student);
}
