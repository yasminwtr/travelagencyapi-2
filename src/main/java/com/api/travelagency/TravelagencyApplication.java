package com.api.travelagency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class TravelagencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelagencyApplication.class, args);
	}

}
