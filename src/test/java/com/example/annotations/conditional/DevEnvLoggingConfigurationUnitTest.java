package com.example.annotations.conditional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

public class DevEnvLoggingConfigurationUnitTest {
	
	private final ApplicationContextRunner contextRunner = new ApplicationContextRunner();
	
	@Test
	public void whenDevEnvEnabled_thenDevEnvLoggingConfigurationAndLoggingServiceShouldBeCreated() {
		
		System.setProperty("env", "dev");
		
		contextRunner
		.withUserConfiguration(ConditionalTestConfiguration.class)
		.run( context -> {
			Assertions.assertNotNull(context.getBean(ConditionalTestConfiguration.class));
		});
		
		contextRunner
		.withUserConfiguration(ConditionalTestConfiguration.class)
		.run( context -> {
			Assertions.assertNotNull(LoggingService.class);
		});
		
	}

}
