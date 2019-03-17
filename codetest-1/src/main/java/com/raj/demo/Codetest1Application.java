package com.raj.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@ComponentScan({"com.raj.demo"})
public class Codetest1Application {

	public static void main(String[] args) {
		SpringApplication.run(Codetest1Application.class, args);
	}

}
