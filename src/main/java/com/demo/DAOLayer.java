package com.demo;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * DAO layer
 * 
 * @author Niranjan Nanda
 */
@Component
public class DAOLayer {
	private static final Logger logger = LoggerFactory.getLogger(DAOLayer.class);

	public String get(final String name) {
		logger.info("DAO Layer: get: name: {}", name);
		
		if (StringUtils.isBlank(name)) {
			return "Hello Annonymous";
		} else {
			return "Hello " + name;
		}
	}
}
