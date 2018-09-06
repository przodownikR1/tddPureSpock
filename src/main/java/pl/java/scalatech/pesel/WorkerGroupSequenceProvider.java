package pl.java.scalatech.pesel;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

public class WorkerGroupSequenceProvider implements DefaultGroupSequenceProvider<Worker> {

  @Override
  public List<Class<?>> getValidationGroups(Worker worker) {
    List<Class<?>> defaultGroupSequence = new ArrayList<>();
    defaultGroupSequence.add(Worker.class);
    return defaultGroupSequence;
  }

}