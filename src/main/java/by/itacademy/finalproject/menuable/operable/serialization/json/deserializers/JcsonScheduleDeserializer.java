package by.itacademy.finalproject.menuable.operable.serialization.json.deserializers;

import by.itacademy.finalproject.domain.schedule.Schedule;
import by.itacademy.finalproject.domain.schedule.TimeOverlapException;
import by.itacademy.finalproject.domain.schedule.TimePeriod;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class JcsonScheduleDeserializer extends StdDeserializer<Schedule> {
    public JcsonScheduleDeserializer() {
        super(Schedule.class);
    }

    @Override
    public Schedule deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        String[] periods = jp.getValueAsString().split(", ");
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
