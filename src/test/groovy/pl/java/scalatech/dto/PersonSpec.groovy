package pl.java.scalatech.dto

import spock.lang.Specification

class PersonSpec extends Specification {


    def "simple DTO test"() {
        given:
            Person p = new Person("slawek", 39)
        and:
            Person expectPerson = new Person()
            expectPerson.name = "slawek"
            expectPerson.age = 39
        expect:
            expectPerson == p
    }
}
