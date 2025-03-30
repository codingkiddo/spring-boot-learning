package com.example.annotations.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Conditional(IsDevEnvCondition.class)
public class DevEnvLoggingConfiguration {

//	@Bean
//	@Conditional(IsDevEnvCondition.class)
//	LoggingService loggingService() {
//		return new LoggingService();
//	}
	
	@Bean(name="loggingService")
	@ConditionalOnProperty( prefix = "notification", name = "service", havingValue = "email" )
	LoggingService loggingService() {
		return new LoggingService();
	}
}
