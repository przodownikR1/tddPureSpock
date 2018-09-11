package pl.java.scalatech.json.event;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.ToString;

@ToString(callSuper=true)
@JsonPropertyOrder({ "lives", "animalUuid", "birthDate" })
class Cat extends Animal {

    public boolean likesCream;
    public int lives;

   
}