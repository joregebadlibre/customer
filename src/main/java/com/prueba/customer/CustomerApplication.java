package com.prueba.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.prueba.customer.repository")
public class CustomerApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerApplication.class, args);
	}

}
