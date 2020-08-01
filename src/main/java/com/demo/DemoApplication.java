package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.web.reactive.config.EnableWebFlux;

import reactor.core.publisher.Hooks;

/**
 * Demo applications
 *
 * @author Niranjan Nanda
 */
@SpringBootApplication
@EnableWebFlux
public class DemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(final String[] args) {
		if (logger.isDebugEnabled()) {
			Hooks.onOperatorDebug();
		}
		
		final SpringApplication springApplication = new SpringApplication(DemoApplication.class);

		// Register this listener which generates the PID file.
		springApplication.addListeners(new ApplicationPidFileWriter());
		springApplication.run(args);
	}
}
