package com.example.watiread.watiread;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WatireadApplication {

	public static void main(String[] args) {
		SpringApplication.run(WatireadApplication.class, args);
	}
	@Value("${allowed.origin}")
	private String allowedOrigin;

	@Bean
	public WebMvcConfigurer corsConfigurer()
	{
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins(allowedOrigin)
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
						.allowedHeaders("Origin", "Content-Type", "Accept", "Authorization")
						.allowCredentials(true);
			}
		};
	}
}
