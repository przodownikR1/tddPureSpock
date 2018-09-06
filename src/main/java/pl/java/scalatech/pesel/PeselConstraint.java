package pl.java.scalatech.pesel;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = PeselValidator.class)
public @interface PeselConstraint {
    String message() default "Wrong pesel";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}