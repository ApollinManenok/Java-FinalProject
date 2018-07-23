package by.itacademy.finalproject.menus.serializing.serialization.json.serializers;

import by.itacademy.finalproject.domain.group.formatter.DateTimeFormat;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class GsonLocalDateSerializer implements JsonSerializer<LocalDate> {
    @Override
    public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
        String birth = src.format(DateTimeFormat.D_M_YYYY_DASH.getFormat());
        return new JsonPrimitive(birth);
    }
}
