package es.cga.sbsample.srv.srvtransaction

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

import es.cga.sbsample.repository.DtoAccountRepository


@SpringBootApplication
//@SpringBootApplication(scanBasePackages = {"es.cga.sbsample"})
//NOTE: in Groovy list annotation attributes mus be enclosed in [] instead of {} 
@EnableJpaRepositories(basePackages = ["es.cga.sbsample.srv.srvtransaction.repository", "es.cga.sbsample.repository"])
@EntityScan(basePackages = ["es.cga.sbsample.srv.srvtransaction.model", "es.cga.sbsample.model.modelsbsample"])

class SpringBootGroovyApplication {
    static void main(String[] args) {
        SpringApplication.run SpringBootGroovyApplication, args
    }
}
