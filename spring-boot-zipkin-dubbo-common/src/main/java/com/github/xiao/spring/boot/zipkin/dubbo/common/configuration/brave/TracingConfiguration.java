package com.github.xiao.spring.boot.zipkin.dubbo.common.configuration.brave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import brave.Tracing;
import brave.http.HttpTracing;
import brave.sampler.Sampler;
import io.zipkin.brave.DubboTracing;
import io.zipkin.brave.TraceConfig;
import zipkin2.Span;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Sender;
import zipkin2.reporter.okhttp3.OkHttpSender;

@Configuration
public class TracingConfiguration {
	@Autowired
	TraceConfig config;

	@Bean
	public Tracing tracing() {
		return Tracing.newBuilder().localServiceName(config.getServerName()).spanReporter(spanReporter())
				.sampler(Sampler.create(config.getRate())).build();
	}

	@Bean
	HttpTracing httpTracing(Tracing tracing) {
		return HttpTracing.create(tracing);
	}

	@Bean
	public AsyncReporter<Span> spanReporter() {
		return AsyncReporter.create(sender());
	}

	@Bean
	public Sender sender() {
		return OkHttpSender.create(config.getEndpoint());
	}

	@Bean
	DubboTracing dubboTracing(Tracing tracing) {
		return DubboTracing.create(tracing);
	}
}
