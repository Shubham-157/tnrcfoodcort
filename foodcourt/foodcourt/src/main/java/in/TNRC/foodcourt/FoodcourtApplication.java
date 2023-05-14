package in.TNRC.foodcourt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories
public class FoodcourtApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodcourtApplication.class, args);
	}

}
