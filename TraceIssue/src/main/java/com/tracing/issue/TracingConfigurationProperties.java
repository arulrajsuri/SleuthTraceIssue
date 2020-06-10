package com.tracing.issue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
@RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
public class TracingConfigurationProperties {
	
	@Value("${prop.trace.name}")
	public String tracingNameKey;
	
	@Value("${prop.span.name}")
	public String tracingSpanNameKey;
}
