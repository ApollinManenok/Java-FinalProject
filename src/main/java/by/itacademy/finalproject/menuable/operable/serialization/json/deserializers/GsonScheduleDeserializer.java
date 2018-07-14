package by.itacademy.finalproject.menuable.operable.serialization.json.deserializers;

import by.itacademy.finalproject.domain.schedule.Schedule;
import by.itacademy.finalproject.domain.schedule.TimeOverlapException;
import by.itacademy.finalproject.domain.schedule.TimePeriod;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class GsonScheduleDeserializer implements JsonDeserializer<Schedule> {
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
                e.printStackTrace();
            }
        }
    }
}
