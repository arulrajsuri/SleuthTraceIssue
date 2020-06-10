package com.tracing.issue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import brave.ScopedSpan;
import brave.propagation.ExtraFieldPropagation;

@SuppressWarnings("deprecation")
@Component
public class TracingInitiationUtil {

	@Autowired
	brave.Tracer tracer;

	@Autowired
	TracingConfigurationProperties tracingConfigurationProperties;

	public ScopedSpan initiateTracing(String traceName) {

		ExtraFieldPropagation.set(tracer.currentSpan().context(), tracingConfigurationProperties.tracingNameKey,
				traceName);
		return createSpan(traceName);
	}

	public ScopedSpan createSpan(String name) {
		return tracer.startScopedSpan(name);
	}

}
