package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**
 * TODO: Add a description
 *
 * @author Niranjan Nanda
 */
@RestController
@RequestMapping("/api")
public class Controller {
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);

	private static final Scheduler APP_WORKER_SCHEDULER = Schedulers.newBoundedElastic(10, 20, "app-worker");
	
	private final ServiceLayer serviceLayer;
	
	@Autowired
	public Controller(final ServiceLayer serviceLayer) {
		this.serviceLayer = serviceLayer;
	}
	
	@GetMapping("/hello/{userName}")
	public Mono<String> reactiveHelloHandler(@PathVariable("userName") final String userName) {
		logger.info("Hello Handler invoked...");
		
		final String responseMessage = "{\"msg\":\"" + serviceLayer.get(userName) + "\"}"; 
		return Mono.just(responseMessage)
				.subscribeOn(APP_WORKER_SCHEDULER);
	}

}
