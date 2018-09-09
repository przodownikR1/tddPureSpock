package pl.java.scalatech.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class EmployeeStaticFactory {
    
        private String name;
        private String dept;

        @JsonCreator
        public static EmployeeStaticFactory createEmployee(@JsonProperty("name") String name,
                                              @JsonProperty("dept") String dept) {
            System.out.println("'factory method invoked'");
            EmployeeStaticFactory employee = new EmployeeStaticFactory();
            employee.name = name;
            employee.dept = dept;
            return employee;
        }
        
}
