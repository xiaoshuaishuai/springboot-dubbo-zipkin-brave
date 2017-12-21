package com.github.xiao.spring.boot.zipkin.dubbo.common.configuration.brave;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.springframework.stereotype.Component;
import brave.Tracing;
import brave.servlet.TracingFilter;

/**
 * servlet support
 * https://github.com/openzipkin/brave/blob/master/instrumentation/servlet/README.md
 * 
 * @since 2017年12月21日 下午3:14:33
 * @author shuaishuaixiao
 */
@Component
@WebFilter(urlPatterns = "/*", filterName = "TracingFilter")
public class ServletContextTracingFilter implements Filter {
	@Resource
	private Tracing tracing;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Filter currentTracingFilter = (Filter) request.getServletContext().getAttribute(TracingFilter.class.getName());
		if (currentTracingFilter == null) {
			chain.doFilter(request, response);
		} else {
			currentTracingFilter.doFilter(request, response, chain);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) {
		// Tracing tracing =
		// Tracing.newBuilder().localServiceName("myservicename").build();
		Filter tracingFilter = TracingFilter.create(tracing);
		filterConfig.getServletContext().setAttribute(TracingFilter.class.getName(), tracingFilter);
	}

	@Override
	public void destroy() {
	}
}