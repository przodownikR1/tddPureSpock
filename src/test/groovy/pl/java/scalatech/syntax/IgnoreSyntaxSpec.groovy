package pl.java.scalatech.syntax
import java.lang.Void as Should

import spock.lang.IgnoreIf
import spock.lang.Requires
import spock.lang.Specification
import spock.util.environment.Jvm
import spock.util.environment.OperatingSystem

class IgnoreSyntaxSpec extends Specification{
    
    @Requires({ OperatingSystem.current.linux })
    Should "only run on Linux"() {
        expect:
        true
    }


    @IgnoreIf({ Jvm.current.java8Compatible })
    Should 'ignored in Java8+'() {
        expect:
        false
    }

    @IgnoreIf({ javaVersion < 1.9 })
    Should 'only run in Java 9 or upper'() {
        expect:
        true
    }


    @IgnoreIf({ Jvm.current.java9 })
    Should 'ignored only in Java9'() {
        expect:
        true
}
}
