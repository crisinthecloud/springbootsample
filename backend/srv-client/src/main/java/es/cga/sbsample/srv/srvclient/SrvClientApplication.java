package es.cga.sbsample.srv.srvclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import es.cga.sbsample.repository.DtoClientRepository;

/**
 * Standar Spring Boot Application class.
 * @author cris
 *
 */
@SpringBootApplication(scanBasePackages = {"es.cga.sbsample"})
@EnableJpaRepositories(basePackages = {"es.cga.sbsample.repository"}, 
basePackageClasses = DtoClientRepository.class)
@EntityScan(basePackages = {"es.cga.sbsample.model"})
public class SrvClientApplication {

    public static void main(String[] args) {
    	SpringApplication.run(SrvClientApplication.class, args);
    }

}
