package com.github.xiao.spring.boot.zipkin.dubbo.common.configuration.brave;

import java.util.EnumSet;

import javax.annotation.Resource;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import brave.Tracing;
import brave.servlet.TracingFilter;

@Deprecated
@WebListener
public class TracingServletContextListener implements ServletContextListener {
	private static final Logger logger = LoggerFactory.getLogger(TracingServletContextListener.class);
	@Resource
	private Tracing tracing;
	
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		logger.info("TracingFilter初始化=============");
		
//		Tracing tracing = Tracing.newBuilder().localServiceName("myservicename").build();
//		servletContextEvent.getServletContext().addFilter("TracingFilter", TracingFilter.create(tracing))
//				.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
	}
}