package pl.java.scalatech.json.event

import java.lang.Void as Should 

import com.fasterxml.jackson.databind.ObjectMapper

import spock.lang.Shared
import spock.lang.Specification

class EventSpec extends Specification {

    @Shared
    ObjectMapper mapper = new ObjectMapper()

    Should "serialize root of objects"() {
        given:
            Cat cat = new Cat()
            cat.name = "Kitty"
            cat.likesCream = false
            cat.lives = 7
        when:
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cat)
        then:
            System.out.println(json)
        when:
            Animal expectedCat = mapper.readValue(json, Animal.class)
        then:
            println expectedCat
    }

}
