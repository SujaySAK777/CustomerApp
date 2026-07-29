package com.example.customerApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerAppApplication {

	public static void main(String[] args) {
        System.out.println("Sql onnected");
		SpringApplication.run(CustomerAppApplication.class, args);

	}

}
