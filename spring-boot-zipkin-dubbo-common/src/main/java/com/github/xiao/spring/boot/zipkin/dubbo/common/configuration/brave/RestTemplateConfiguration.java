//package com.github.xiao.spring.boot.zipkin.dubbo.common.configuration.brave;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.ClientHttpRequestInterceptor;
//import org.springframework.web.client.RestTemplate;
//
//import brave.http.HttpTracing;
//import brave.spring.web.TracingClientHttpRequestInterceptor;
///**
// * https://github.com/openzipkin/brave/blob/master/instrumentation/spring-web/README.md
// * Spring RestTemplate.
// */
//@Configuration
//public class RestTemplateConfiguration {
//
//
//	@Bean
//	ClientHttpRequestInterceptor tracingInterceptor(HttpTracing httpTracing) {
//		return TracingClientHttpRequestInterceptor.create(httpTracing);
//	}
//	@Autowired
//	private ClientHttpRequestInterceptor tracingInterceptor;
//
//	@Bean
//	RestTemplate restTemplate() {
//		RestTemplate restTemplate = new RestTemplate();
//		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
//		interceptors.add(tracingInterceptor);
//		restTemplate.setInterceptors(interceptors);
//		return restTemplate;
//	}
//}
