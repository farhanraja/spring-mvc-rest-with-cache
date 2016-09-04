package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This is the main class responsible to initialize and start up the
 * application.
 * 
 * @author Farhan
 *
 */

@SpringBootApplication
@Configuration
@ComponentScan("com.*")
@EnableCaching
public class Main {

	/**
	 * Main method responsible to start the application up.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);

		System.out.println("\n----------------------------------------");
		System.out.println("Base URL:     http://localhost:8080/\n");
		System.out.println("Add API:      http://localhost:8080/add/{a}/{b}/{c}");
		System.out.println("Add API:      http://localhost:8080/add/{a}/{b}");
		System.out.println("Subtract API: http://localhost:8080/subtract/{a}/{b}/{c}");
		System.out.println("Subtract API: http://localhost:8080/subtract/{a}/{b}");
		System.out.println("Multiply API: http://localhost:8080/multiply/{a}/{b}/{c}");
		System.out.println("Multiply API: http://localhost:8080/multiply/{a}/{b}");
		System.out.println("Divide API:   http://localhost:8080/divide/{a}/{b}");
		System.out.println("\n----------------------------------------");
	}
}
