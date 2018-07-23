package by.itacademy.finalproject.menus.operable.review.reviewable.birthdays;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.menus.operable.review.reviewable.Reviewable;
import by.itacademy.finalproject.menus.operable.review.reviewable.birthdays.info.BirthdayInfo;
import by.itacademy.finalproject.menus.serialize.serialization.json.ReadLocalGsonTest;
import by.itacademy.finalproject.menus.serializing.serialization.json.ReadLocalGson;
import org.junit.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ResentBirthdayReviewerTest {
    private Reviewable<BirthdayInfo> reviewer = new ResentBirthdayReviewer();
    private School school = new School();
    private String fileName = "TestSchool.json";
    private ReadLocalGson reader = new ReadLocalGson(school, new File(ReadLocalGsonTest.class
            .getClassLoader().getResource(fileName).getFile()));

    @Test
    public void checkBirthdayInfoAreInRightTimeBounds() {
        reader.serialize();
        List<BirthdayInfo> infos = reviewer.review(school.getGroups());
        for (BirthdayInfo info : infos) {
            int dateDayOfYear = info.getDate().getDayOfYear();
            int earliestBound = LocalDate.now().withDayOfMonth(1).getDayOfYear();
            int latestBound = LocalDate.now().withDayOfMonth(1).plusMonths(2).getDayOfYear();
            assertTrue(dateDayOfYear >= earliestBound && dateDayOfYear < latestBound);
        }
    }
}
