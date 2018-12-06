package my.webapp

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class MyControllerSpec extends Specification implements ControllerUnitTest<MyController> {

    FooService fooService

    def setup() {
        fooService = Mock(FooService)

        controller.fooService = fooService
    }

    /**
     * Workaround as suggested by jameskleeh
     * @see https://github.com/grails/grails-core/issues/11198#issuecomment-445011469
     */
    @Override
    boolean disableControllerProxy() {
        return true
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
     * Direct invocation works as expected
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
