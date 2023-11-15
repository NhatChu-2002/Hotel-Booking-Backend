package com.pbl6.hotelbookingapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HotelBookingAppApplication {
	@Value("${allowed.origins}")
	private String[] theAllowedOrigins;
	@Value("${spring.data.rest.base-path}")
	private String basePath;
	public static void main(String[] args) {
		SpringApplication.run(HotelBookingAppApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping(basePath + "/**")
						.allowedOrigins("http://localhost:3000")
						.allowedMethods("GET", "POST", "PUT", "DELETE","PATCH")
						.allowedHeaders("*");
			}
		};
	}

}

