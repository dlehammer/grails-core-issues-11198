package my.webapp

import grails.gorm.transactions.Transactional

@Transactional
class FooService {

    def serviceMethod() {
        return 'serviceMethod HIT'
    }
}
