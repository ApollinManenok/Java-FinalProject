package by.itacademy.finalproject.menus.serializing.serialization.json;


import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.domain.group.schedule.Schedule;
import by.itacademy.finalproject.menus.serializing.serialization.ReadGroups;
import by.itacademy.finalproject.menus.serializing.serialization.json.deserializers.GsonLocalDateDeserializer;
import by.itacademy.finalproject.menus.serializing.serialization.json.deserializers.GsonScheduleDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadLocalGson extends ReadGroups {
    private static final Logger LOGGER = Logger.getLogger(ReadLocalGson.class.getName());

    public ReadLocalGson(School school, String source) {
        super(school, source);
    }

    public ReadLocalGson(School school, File file) {
        super(school, file);
    }

    @Override
    public void serialize() {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new GsonLocalDateDeserializer())
                .registerTypeAdapter(Schedule.class, new GsonScheduleDeserializer()).create();
        try (JsonReader reader = new JsonReader(new FileReader(getFile()))) {
            School temp = gson.fromJson(reader, School.class);
            checkedAddAllGroups(temp);
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
        return "Read groups info from local json file";
    }
}
