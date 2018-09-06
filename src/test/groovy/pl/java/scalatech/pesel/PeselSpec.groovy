package pl.java.scalatech.pesel

import java.lang.Void as Should

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Subject
@Subject(Worker)
class PeselSpec extends Specification {

    @Shared
    Validator validator

    def setupSpec() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory()
        validator = factory.getValidator()
    }

    Should "pesel validator"() {
        given:
            Worker objectUnderTest = new Worker()
            objectUnderTest.setName("slawek")
            objectUnderTest.setPesel("79050305971")
        when:
            def exceptions = validator.validateProperty(objectUnderTest, "pesel")
        then:
            println exceptions.getAt(0).getMessage()
    }
}
