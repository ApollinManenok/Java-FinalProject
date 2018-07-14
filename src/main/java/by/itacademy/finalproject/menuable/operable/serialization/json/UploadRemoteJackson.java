package by.itacademy.finalproject.menuable.operable.serialization.json;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.schedule.Schedule;
import by.itacademy.finalproject.menuable.operable.serialization.UploadGroups;
import by.itacademy.finalproject.menuable.operable.serialization.json.deserializers.JcsonLocalDateDeserializer;
import by.itacademy.finalproject.menuable.operable.serialization.json.deserializers.JcsonScheduleDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UploadRemoteJackson extends UploadGroups {
    private static final Logger LOGGER = Logger.getLogger(UploadRemoteJackson.class.getName());

    public UploadRemoteJackson(School school, String source) {
        super(school, source);
    }

    public UploadRemoteJackson(School school, URL url) {
        super(school, url);
    }

    @Override
    public void serialize() {
        try {
            School temp = new ObjectMapper()
                    .registerModule(new SimpleModule().addDeserializer(LocalDate.class, new JcsonLocalDateDeserializer())
                            .addDeserializer(Schedule.class, new JcsonScheduleDeserializer()))
                    .readValue(getUrl(), School.class);
            getSchool().addAllGroups(temp.getGroups());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Override
    public String typo() {
        return "Upload groups info from remote json file";
    }
}
