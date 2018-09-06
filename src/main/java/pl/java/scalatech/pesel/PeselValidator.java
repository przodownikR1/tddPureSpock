package pl.java.scalatech.pesel;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.Integer.parseInt;
import static java.util.Objects.requireNonNull;
import static pl.java.scalatech.pesel.PeselIdentity.regex;

import java.util.regex.Matcher;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PeselValidator implements ConstraintValidator<PeselConstraint, String> {
    private static final String LAST = "last";
    private final int checksum[] = { 1, 3, 7, 9, 1, 3, 7, 9, 1, 3 };
    private  Matcher matches;

    @Override
    public boolean isValid(String pesel, ConstraintValidatorContext context) {
        requireNonNull(pesel);
        checkArgument(pesel.length()!=0);
        preparedMatcher(pesel);
        int sum = 0;
        int position = 0;
        for (int weight : checksum) {
            int number = parseInt(pesel.substring(position, position + 1));
            sum += number * weight;
            position++;
        }

        sum %= 10;
        sum = 10 - sum;
        sum %= 10;

        int last = parseInt(matches.group(LAST));
        return last == sum;
    }

    private void preparedMatcher(String pesel) {
        matches = regex.matcher(pesel);
        matches.matches();
    }
}