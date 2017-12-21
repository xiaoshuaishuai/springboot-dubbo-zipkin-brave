package com.github.xiao.spring.boot.zipkin.dubbo.common.configuration.brave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import brave.http.HttpTracing;
import brave.spring.webmvc.TracingAsyncHandlerInterceptor;

/**
 * springmvc support
 * 
 * @author shuaishuaixiao
 * @link https://github.com/openzipkin/brave/blob/master/instrumentation/spring-webmvc/README.md
 */
@Configuration
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
	@Bean
	AsyncHandlerInterceptor tracingInterceptor(HttpTracing httpTracing) {
		return TracingAsyncHandlerInterceptor.create(httpTracing);
	}

	@Autowired
	private AsyncHandlerInterceptor tracingInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(tracingInterceptor);
	}
}