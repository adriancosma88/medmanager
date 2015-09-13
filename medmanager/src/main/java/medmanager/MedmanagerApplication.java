package medmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan ({"configuration"})
public class MedmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedmanagerApplication.class, args);
    }
}
