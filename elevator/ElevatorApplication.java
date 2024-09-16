package com.gr.elevator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EntityScan(basePackages = "com.gr.*")
@EnableJpaRepositories(basePackages = "com.gr.*")
public class ElevatorApplication {
	public static void main(String[] args) {
		SpringApplication.run(ElevatorApplication.class, args);
	}
}
