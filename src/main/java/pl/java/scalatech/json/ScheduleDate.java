package pl.java.scalatech.json;

import static com.google.common.base.CharMatcher.inRange;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;
import static java.lang.Integer.parseInt;
import static java.time.DayOfWeek.of;

import java.io.Serializable;
import java.time.DayOfWeek;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.ToString;

@ToString
@JsonSerialize(using = ScheduleDateSerializer.class)
@JsonDeserialize(using = ScheduleDateDeserialize.class)
public final class ScheduleDate implements Serializable {

    private static final long serialVersionUID = -719394618636537296L;
    private static final int NEXT_NUMBER_OF_WEEK_END_POSITION = 2;
    private static final int MAX_LENGHT_OF_SCHEDULE = 3;


    @Getter
    private final String schedule;

    public ScheduleDate(String scheduleDateAsString) {
        preconditions(scheduleDateAsString);
        schedule = numberOfWeekValidator(scheduleDateAsString) + dayOfWeekValidator(scheduleDateAsString).getValue();
    }

    private void preconditions(String scheduleDateAsString) {
        checkArgument(!isNullOrEmpty(scheduleDateAsString), "scheduleDate can't be null or empty");
        checkArgument(inRange('0', '9').matchesAllOf(scheduleDateAsString), "scheduleDate must contains only with digits");
        checkArgument(scheduleDateAsString.length() == MAX_LENGHT_OF_SCHEDULE, "scheduleDate must consists of exactly three digits");
    }

    private String numberOfWeekValidator(String scheduleDate) {
        return scheduleDate.substring(0, NEXT_NUMBER_OF_WEEK_END_POSITION);
    }

    private DayOfWeek dayOfWeekValidator(String scheduleDate) {
        return of(parseInt(scheduleDate.substring(NEXT_NUMBER_OF_WEEK_END_POSITION, scheduleDate.length())));
    }
}