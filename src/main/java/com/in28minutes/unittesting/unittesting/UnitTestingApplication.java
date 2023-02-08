package com.in28minutes.unittesting.unittesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnitTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestingApplication.class, args);
	}
	//https://stackoverflow.com/questions/61865206/springboot-2-3-0-while-connecting-to-h2-database
	//jdbc:h2:mem:testdb
	//http://localhost:8080/h2-console
}
