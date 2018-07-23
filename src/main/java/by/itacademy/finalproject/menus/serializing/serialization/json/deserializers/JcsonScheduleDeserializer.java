package by.itacademy.finalproject.menus.serializing.serialization.json.deserializers;

import by.itacademy.finalproject.domain.group.schedule.Schedule;
import by.itacademy.finalproject.domain.group.schedule.TimeOverlapException;
import by.itacademy.finalproject.domain.group.schedule.TimePeriod;
import by.itacademy.finalproject.menus.serializing.serialization.xml.maker.TeacherMaker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JcsonScheduleDeserializer extends StdDeserializer<Schedule> {
    private static final Logger LOGGER = Logger.getLogger(JcsonScheduleDeserializer.class.getName());

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
                LOGGER.log(Level.WARNING, e.getMessage(), e);
            }
        }
    }
}
