package pl.java.scalatech.json;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonCreatorConstructorExample {
    public static void main(String[] args) throws IOException {
        System.out.println("-- writing --");
        Employee employee = new Employee("Trish", "Admin");
        //convert to json
        String jsonString = toJson(employee);
        System.out.println(jsonString);
        System.out.println("-- reading --");
        Employee e = toEmployee(jsonString);
        System.out.println(e);
    }

    private static Employee toEmployee(String jsonData) throws IOException {
        ObjectMapper om = new ObjectMapper();
        return om.readValue(jsonData, Employee.class);
    }

    private static String toJson(Employee employee) throws IOException {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(employee);
    }

}