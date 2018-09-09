package pl.java.scalatech.json;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = User.UserBuilder.class)
public class User {

    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private int age;
    @Builder.Default
    private final int userType = 2;

    @JsonPOJOBuilder(withPrefix = "")
    final static class UserBuilder {

    }
}
