package com.github.xiao.spring.boot.zipkin.dubbo.common.adapter.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import brave.http.HttpServerAdapter;

public class OwnHttpServerAdapter extends HttpServerAdapter<HttpServletRequest, HttpServletResponse>{
	private static final Logger logger = LoggerFactory.getLogger(OwnHttpServerAdapter.class);

	@Override
	public String method(HttpServletRequest request) {
		logger.info("OwnHttpServerAdapter method");
		return request.getMethod();
	}

	@Override
	public String path(HttpServletRequest request) {
		logger.info("OwnHttpServerAdapter path");
		return request.getRequestURI().toString();
	}

	@Override
	public String url(HttpServletRequest request) {
		logger.info("OwnHttpServerAdapter url");
		return request.getRequestURL().toString();
	}

	@Override
	public String requestHeader(HttpServletRequest request, String name) {
		logger.info("OwnHttpServerAdapter requestHeader");
		return request.getHeader(name);
	}

	@Override
	public Integer statusCode(HttpServletResponse response) {
		logger.info("OwnHttpServerAdapter statusCode");
		return response.getStatus();
	}
}