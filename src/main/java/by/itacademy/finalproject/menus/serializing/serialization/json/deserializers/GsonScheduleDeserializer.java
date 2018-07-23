package by.itacademy.finalproject.menus.serializing.serialization.json.deserializers;

import by.itacademy.finalproject.domain.group.schedule.Schedule;
import by.itacademy.finalproject.domain.group.schedule.TimeOverlapException;
import by.itacademy.finalproject.domain.group.schedule.TimePeriod;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GsonScheduleDeserializer implements JsonDeserializer<Schedule> {
    private static final Logger LOGGER = Logger.getLogger(GsonScheduleDeserializer.class.getName());

    @Override
    public Schedule deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String[] periods = json.getAsJsonPrimitive().getAsString().split(", ");
        Schedule schedule = new Schedule();
        fillSchedule(schedule, periods);
        return schedule;
    }

    private void fillSchedule(Schedule schedule, String[] periods) {
        for (String period : periods) {
            try {
                schedule.addTime(new TimePeriod(period));
            } catch (TimeOverlapException e) {
                LOGGER.log(Level.WARNING, e.getMessage(), e);
            }
        }
    }
}
