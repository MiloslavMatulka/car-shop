package com.engeto.carshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot application that defines endpoints for REST API with MySQL
 * database.
 *
 * @author Miloslav Matulka (Discord tag Miloslav#8572)
 */
@SpringBootApplication
public class CarShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarShopApplication.class, args);
	}

}
