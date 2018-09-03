package pl.java.scalatech.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;

public class ScheduleDateDeserialize extends JsonDeserializer<ScheduleDate> {

    private static final String SCHEDULE_DAY = "scheduleDay";

    @Override
    public ScheduleDate deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        TreeNode treeNode = parser.getCodec().readTree(parser);
        TextNode schedule = (TextNode) treeNode.get(SCHEDULE_DAY);
        return new ScheduleDate(schedule.asText());
    }
}
