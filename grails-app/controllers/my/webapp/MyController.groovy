package my.webapp

class MyController {

    FooService fooService

    def index() {
        commonLogic()
    }

    private def commonLogic() {
        def o = fooService.serviceMethod()

        render text: o
    }

}
