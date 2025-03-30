package com.example.annotations.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(IsDevEnvCondition.class)
public class DevEnvLoggingConfiguration {

	@Bean
	LoggingService loggingService() {
		return new LoggingService();
	}
}
