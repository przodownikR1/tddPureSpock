package pl.java.scalatech.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ScheduleDateSerializer extends JsonSerializer<ScheduleDate> {

    @Override
    public void serialize(ScheduleDate schedule, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("scheduleDay", schedule.getSchedule());
        gen.writeEndObject();
    }

}
