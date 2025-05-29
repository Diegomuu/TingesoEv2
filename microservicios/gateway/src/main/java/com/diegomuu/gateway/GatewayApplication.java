package com.diegomuu.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GatewayApplication {


	@Configuration
	public class RestTemplateConfig {
		@Bean
		public RestTemplate restTemplate() {
			return new RestTemplate();
		}
	}


	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
