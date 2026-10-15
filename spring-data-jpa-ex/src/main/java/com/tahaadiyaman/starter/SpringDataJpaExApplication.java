package com.tahaadiyaman.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.tahaadiyaman"})
@SpringBootApplication
@ComponentScan(basePackages = {"com.tahaadiyaman"})
@EnableJpaRepositories(basePackages = {"com.tahaadiyaman"})
public class SpringDataJpaExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaExApplication.class, args);
	}

}
