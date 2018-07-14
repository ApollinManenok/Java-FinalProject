package by.itacademy.finalproject.menuable.operable.serialization.json.deserializers;


import by.itacademy.finalproject.domain.formatter.DateTimeFormat;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class GsonLocalDateDeserializer implements JsonDeserializer<LocalDate> {
    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String date = json.getAsJsonPrimitive().getAsString();
        return LocalDate.parse(date, DateTimeFormat.D_M_YYYY_DASH.getFormat());
    }
}
