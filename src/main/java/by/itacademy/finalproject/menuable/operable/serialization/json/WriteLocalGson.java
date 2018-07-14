package by.itacademy.finalproject.menuable.operable.serialization.json;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.schedule.Schedule;
import by.itacademy.finalproject.menuable.operable.serialization.WriteGroups;
import by.itacademy.finalproject.menuable.operable.serialization.json.serializers.GsonLocalDateSerializer;
import by.itacademy.finalproject.menuable.operable.serialization.json.serializers.GsonScheduleSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteLocalGson extends WriteGroups {
    private static final Logger LOGGER = Logger.getLogger(WriteLocalGson.class.getName());

    public WriteLocalGson(School school, String source) {
        super(school, source);
    }

    public WriteLocalGson(School school, File file) {
        super(school, file);
    }

    @Override
    public void serialize() {

        try (Writer writer = new FileWriter(getFile())) {
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new GsonLocalDateSerializer())
                    .registerTypeAdapter(Schedule.class, new GsonScheduleSerializer()).setPrettyPrinting().create();
            gson.toJson(getSchool(), writer);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Can't get FileWriter from " + getSource(), e);
        }
    }

    @Override
    public String typo() {
        return "Write groups info into local json file";
    }
}
