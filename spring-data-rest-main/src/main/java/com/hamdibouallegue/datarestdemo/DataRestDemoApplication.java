package com.hamdibouallegue.datarestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.hamdibouallegue.datarestdemo.models.IansCountry;

@SpringBootApplication
public class DataRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataRestDemoApplication.class, args);
	}
	
}
