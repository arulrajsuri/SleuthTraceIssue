package com.tracing.issue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import brave.ScopedSpan;

@RestController
public class ApplicationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);

	@Autowired
	TracingInitiationUtil tracingInitUtil;

	@Autowired
	ApplicationService applicationService;

	@RequestMapping(method = RequestMethod.GET, path = "/getdata")
	public String getData() {
		ScopedSpan span = tracingInitUtil.initiateTracing("Trace-App");
		try {
			LOGGER.info("Get data executed in ApplicationController");
			return applicationService.getServiceData();
		} finally {
			span.finish();
		}
	}
}
