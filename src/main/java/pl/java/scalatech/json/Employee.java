package pl.java.scalatech.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
class Employee {
        private String name;
        private String dept;

        @JsonCreator
        public Employee(@JsonProperty("name") String name, @JsonProperty("dept") String dept) {
            System.out.println("'constructor invoked'");
            this.name = name;
            this.dept = dept;
        }
    }