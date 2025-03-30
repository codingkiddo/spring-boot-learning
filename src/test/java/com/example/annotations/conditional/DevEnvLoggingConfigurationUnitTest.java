package com.example.annotations.conditional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;


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
		.withPropertyValues("notification.service=email")
		.withUserConfiguration(ConditionalTestConfiguration.class)
		.run( context -> {
			assertThat(context).hasBean("loggingService");
		});
		
		
	}

}
