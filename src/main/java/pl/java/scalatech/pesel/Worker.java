package pl.java.scalatech.pesel;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.group.GroupSequenceProvider;

import lombok.Data;

@Data
@GroupSequenceProvider(WorkerGroupSequenceProvider.class)
public class Worker {

    private String name;

    @NotBlank
    @PeselConstraint(groups= {Expensive.class})
    private String pesel;
}
