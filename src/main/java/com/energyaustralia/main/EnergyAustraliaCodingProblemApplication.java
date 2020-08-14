package com.energyaustralia.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.energyaustralia.client"})
public class EnergyAustraliaCodingProblemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnergyAustraliaCodingProblemApplication.class, args);
	}

}
