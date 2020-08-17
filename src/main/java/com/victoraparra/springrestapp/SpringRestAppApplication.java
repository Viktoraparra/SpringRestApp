package com.victoraparra.springrestapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class SpringRestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestAppApplication.class, args);
	}

	// me permite crear diferentes en beans en diferentes profiles
	@Profile("dev")
	@Bean
	public String dummy(){
		return "something";
	}
}
