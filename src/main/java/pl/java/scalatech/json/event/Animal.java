package pl.java.scalatech.json.event;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ 
        @JsonSubTypes.Type(value = Cat.class, name = "Cat"),
        @JsonSubTypes.Type(value = Dog.class, name = "Dog")
})
//Jackson is not able to map the type name to a class. 
//To solve the problem we provide sub-class information with the JsonSubTypes annotation:

//We can help Jackson annotating the super-class with the JsonTypeInfo annotation.
//The annotation will add type information to the generated JSON.
public abstract class Animal {
    final LocalDate birthDate = LocalDate.now();
    final UUID animalUuid = UUID.randomUUID();
    public String name;

    
}