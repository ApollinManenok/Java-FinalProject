package by.itacademy.finalproject.menuable.operable.serialization.json.deserializers;

import by.itacademy.finalproject.domain.formatter.DateTimeFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;

public class JcsonLocalDateDeserializer extends StdDeserializer<LocalDate> {
    public JcsonLocalDateDeserializer() {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String date = jp.getValueAsString();
        return LocalDate.parse(date, DateTimeFormat.D_M_YYYY_DASH.getFormat());
    }
}
