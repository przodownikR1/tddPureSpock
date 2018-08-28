package pl.java.scalatech.dto;

import java.util.Arrays;

public enum Weekday {

    SUNDAY("Sun", 1), MONDAY("Mon", 2), TUESDAY("Tue", 3), WEDNESDAY("Wed", 4), THURSDAY("Thu", 5), FRIDAY("Fri", 6), SATURDAY("Sat", 7);

    public static Weekday valueOfAbbreviation(String abbreviation) {

        return Arrays.stream(values())
                .filter(day -> day.getAbbreviation().equalsIgnoreCase(abbreviation))
                .findFirst()
                .orElse(null);
    }

    public static Weekday valueOfPosition(int position) {

        return Arrays.stream(values())
                .filter(day -> day.getPosition() == position)
                .findFirst()
                .orElse(null);
    }

    private final int position;
    private final String abbreviation;

    Weekday(String abbreviation, int position) {

        this.abbreviation = abbreviation;
        this.position = position;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return getAbbreviation();
    }
}