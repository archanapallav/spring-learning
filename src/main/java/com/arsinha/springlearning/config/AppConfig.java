package com.arsinha.springlearning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class AppConfig {

	@Bean(name ="version")
	public String version() {
		return "0.0.1";
	}
	@Profile("dev")
	@Bean(name =  "version")
	public String prodVersion() {
		return "0.0.2";
	}
	
	
}
