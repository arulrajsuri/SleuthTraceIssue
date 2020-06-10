package com.tracing.issue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationService.class);
	
	String sampleString;
	public String getServiceData()
	{
		LOGGER.info("Get service data executed in ApplicationService");
		sampleString.length();
		return "Hello World Service Data";
	}
}
