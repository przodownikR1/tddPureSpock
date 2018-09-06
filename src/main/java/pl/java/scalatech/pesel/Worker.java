package pl.java.scalatech.pesel;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.groups.Default;

import lombok.Data;

@Data
@GroupSequence({Default.class, Expensive.class})
public class Worker {

    private String name;

    @NotBlank
    @PeselConstraint(groups= {Expensive.class})
    private String pesel;
}
