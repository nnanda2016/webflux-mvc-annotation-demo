package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service layer
 * 
 * @author Niranjan Nanda
 */
@Component
public class ServiceLayer {
	private static final Logger logger = LoggerFactory.getLogger(ServiceLayer.class);
	
	private final DAOLayer dao;
	
	@Autowired
	public ServiceLayer(final DAOLayer dao) {
		this.dao = dao;
	}
	
	public String get(final String name) {
		logger.info("ServiceLayer: name: {}", name);
		return dao.get(name);
	}
}
