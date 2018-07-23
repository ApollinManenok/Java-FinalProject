package by.itacademy.finalproject.menus.operable.review.reviewable.birthdays;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.menus.operable.review.reviewable.Reviewable;
import by.itacademy.finalproject.menus.operable.review.reviewable.birthdays.info.BirthdayInfo;
import by.itacademy.finalproject.menus.serialize.serialization.json.ReadLocalGsonTest;
import by.itacademy.finalproject.menus.serializing.serialization.json.ReadLocalGson;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BirthdayReviewerTest {
    private Reviewable<BirthdayInfo> reviewer = new BirthdayReviewer();
    private School school = new School();
    private String fileName = "TestSchool.json";
    private ReadLocalGson reader = new ReadLocalGson(school, new File(ReadLocalGsonTest.class
            .getClassLoader().getResource(fileName).getFile()));

    @Test
    public void checkAmountOfBirthdaysInBirthdayInfoList() {
        reader.serialize();
        List<BirthdayInfo> infos = reviewer.review(school.getGroups());
        assertEquals(10, infos.size());
    }
}
