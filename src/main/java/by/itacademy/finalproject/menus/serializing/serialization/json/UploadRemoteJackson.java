package by.itacademy.finalproject.menus.serializing.serialization.json;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.schedule.Schedule;
import by.itacademy.finalproject.menus.serializing.serialization.UploadGroups;
import by.itacademy.finalproject.menus.serializing.serialization.json.deserializers.JcsonLocalDateDeserializer;
import by.itacademy.finalproject.menus.serializing.serialization.json.deserializers.JcsonScheduleDeserializer;
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
            checkedAddAllGroups(temp);
            getSchool().addAllGroups(temp.getGroups());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private void checkedAddAllGroups(School school) {
        for (Group group : school.getGroups()) {
            if (getSchool().containsGroup(group)) {
                getSchool().getGroup(group).addAllSupplementStudents(group.getStudents());
            }
            getSchool().addGroup(group);
        }
    }

    @Override
    public String typo() {
        return "Upload groups info from remote json file";
    }
}
