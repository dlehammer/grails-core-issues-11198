package my.webapp

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

/**
 * Class containing symptom, see "test commonLogic"
 */
class MyControllerSpec extends Specification implements ControllerUnitTest<MyController> {

    FooService fooService

    def setup() {
        fooService = Mock(FooService)

        controller.fooService = fooService
    }

    /**
     * Indirect invocation works as expected
     */
    void 'test index'() {
        given:
            String bar = 'bar'

        when:
            controller.index()

        then: "expect commonLogic return value to be present"
            response.text == bar

            1 * fooService.serviceMethod() >> bar
            0 * _._
    }

    /**
     * Direct invocation throws {@code NullPointerException}, because fooService is {@code null}
     */
    void 'test commonLogic'() {
        given:
            String bar = 'bar'

        when:
            controller.commonLogic()

        then: "expect commonLogic return value to be present"
            response.text == bar

            1 * fooService.serviceMethod() >> bar
            0 * _._
    }

}
