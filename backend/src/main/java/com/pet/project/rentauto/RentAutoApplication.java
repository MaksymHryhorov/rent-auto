package com.pet.project.rentauto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.pet.project.rentauto")
public class RentAutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentAutoApplication.class, args);
	}

}
