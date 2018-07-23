package by.itacademy.finalproject.menus.operable.review.reviewable.paid;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.menus.operable.review.reviewable.Reviewable;
import by.itacademy.finalproject.menus.operable.review.reviewable.paid.info.PaidInfo;
import by.itacademy.finalproject.menus.serialize.serialization.json.ReadLocalGsonTest;
import by.itacademy.finalproject.menus.serializing.serialization.json.ReadLocalGson;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PaymentsReviewerTest {
    private Reviewable<PaidInfo> reviewer = new PaymentsReviewer();
    private School school = new School();
    private String fileName = "TestSchool.json";
    private ReadLocalGson reader = new ReadLocalGson(school, new File(ReadLocalGsonTest.class
            .getClassLoader().getResource(fileName).getFile()));

    @Test
    public void checkPaidInfoContainsAllStudentsPaidInfo() {
        reader.serialize();
        List<PaidInfo> infos = reviewer.review(school.getGroups());
        assertEquals(7, infos.size());
    }
}
