package es.cga.sbsample.srv.srvtransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import es.cga.sbsample.repository.DtoAccountRepository;

/**
 * Standar Spring Boot Application class.
 * @author cris
 *
 */
@SpringBootApplication(scanBasePackages = {"es.cga.sbsample"})
@EnableJpaRepositories(basePackages = {"es.cga.sbsample.repository"}, 
basePackageClasses = DtoAccountRepository.class)
@EntityScan(basePackages = {"es.cga.sbsample.model"})
public class SrvTransactionApplication {

    public static void main(String[] args) {
    	SpringApplication.run(SrvTransactionApplication.class, args);
    }

}
