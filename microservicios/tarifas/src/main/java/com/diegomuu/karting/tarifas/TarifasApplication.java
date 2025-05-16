package com.diegomuu.karting.tarifas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.diegomuu.karting.tarifas.entity")
@EnableJpaRepositories

public class TarifasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarifasApplication.class, args);
	}

}
