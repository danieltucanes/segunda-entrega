package com.unicauca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @brief Aplicacion principal con la anotacion SpringBootApplication
 * @author Andres Felipe Castro (andresfcastro@unicauca.edu.co)
 */


@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
