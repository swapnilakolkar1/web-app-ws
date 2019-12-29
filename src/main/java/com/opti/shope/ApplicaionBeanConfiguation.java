package com.opti.shope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ApplicaionBeanConfiguation {
	@Bean
	public BCryptPasswordEncoder getBcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SpringApplicationContext getContext() {
		return new SpringApplicationContext();
	}
}
