package by.itacademy.finalproject.menus.serializing.serialization.json.serializers;

import by.itacademy.finalproject.domain.group.schedule.Schedule;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class GsonScheduleSerializer implements JsonSerializer<Schedule> {
    @Override
    public JsonElement serialize(Schedule src, Type typeOfSrc, JsonSerializationContext context) {
        String schedule = src.getTimetableAsString();
        return new JsonPrimitive(schedule);
    }
}
