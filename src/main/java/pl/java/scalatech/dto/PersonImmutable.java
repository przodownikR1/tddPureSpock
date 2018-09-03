package pl.java.scalatech.dto;

import lombok.Builder;
import lombok.Value;


@Value
@Builder
final class PersonImmutable {
    private final String name;
    private final int age;
}
