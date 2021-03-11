package com.opti.shope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.opti.shope.app.security.SecurityConstants;

@Configuration
public class CorsConfiguration {
	@Bean
	public WebMvcConfigurer corsConfig() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedHeaders(SecurityConstants.USER_ID_STRING,
						SecurityConstants.AUTHORIZATION_STRING).allowedMethods("*").allowedOrigins("*");
			}
		};
	}
}
