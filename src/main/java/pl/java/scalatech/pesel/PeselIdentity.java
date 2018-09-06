package pl.java.scalatech.pesel;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class PeselIdentity {
    private static final String SEX = "sex";
    private static final String MONTH = "month";
    private static final String YEAR = "year";
    private static final String DAY = "day";
    private final int centuries[] = { 1900, 2000, 2100, 2200, 1800 };
    private static final byte PESEL_LENGTH = 11;
    static final Pattern regex = Pattern.compile("(?<year>\\d{2})(?<month>\\d{2})(?<day>\\d{2})\\d{3}(?<sex>\\d)(?<last>\\d)");
    final Matcher matches;
    private final String pesel;

    public PeselIdentity(String pesel) {
        checkPreconditions(pesel);
        matches = regex.matcher(pesel);
        matches.matches();
        this.pesel = pesel;
    }

    private void checkPreconditions(String peselAsString) {
        checkNotNull(peselAsString);
        checkArgument(!peselAsString.isEmpty());
        checkArgument(PESEL_LENGTH == peselAsString.length());
        checkArgument(regex.matcher(peselAsString).find(), "The PESEL number contains incorrect characters");
    }

    public String getBirthDate() {
        int day = Integer.parseInt(matches.group(DAY));
        int year = Integer.parseInt(matches.group(YEAR));
        int month = Integer.parseInt(matches.group(MONTH));
        int century = month / 20;
        int yearBase = centuries[century];
        year = yearBase + year;
        month %= 20;
        return String.format("%04d%02d%02d", year, month, day);
    }

    public Gender getGender() {
        return Integer.parseInt(matches.group(SEX)) % 2 == 1 ? Gender.MALE : Gender.FEMALE;
    }

    public String pesel() {
        return this.pesel;
    }

    @Override
    public String toString() {
        return Objects.toString(this.pesel);
    }
}