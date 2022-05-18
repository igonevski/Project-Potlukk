package dev.group1.Potlukk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "dev.group1.Potlukk")
@EntityScan(basePackages = "dev.group1.Potlukk.entities")
@EnableJpaRepositories(basePackages = "dev.group1.Potlukk.repos")
public class PotlukkApplication {

	public static void main(String[] args) {
		SpringApplication.run(PotlukkApplication.class, args);
	}

}
