package by.itacademy.finalproject.menuable.operable.serialization.json;


import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.schedule.Schedule;
import by.itacademy.finalproject.menuable.operable.serialization.ReadGroups;
import by.itacademy.finalproject.menuable.operable.serialization.json.deserializers.GsonLocalDateDeserializer;
import by.itacademy.finalproject.menuable.operable.serialization.json.deserializers.GsonScheduleDeserializer;
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
            getSchool().addAllGroups(temp.getGroups());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Override
    public String typo() {
        return "Read groups info from local json file";
    }
}
