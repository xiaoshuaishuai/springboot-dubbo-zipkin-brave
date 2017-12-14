package com.github.xiao.spring.boot.zipkin.dubbo.customer.service.impl;

import org.springframework.stereotype.Service;

import com.github.xiao.spring.boot.zipkin.dubbo.api.dubboservice.IDemoDubboService;
@Service
public class DemoServiceImpl implements com.github.xiao.spring.boot.zipkin.dubbo.customer.service.IDemoService {
	
	@com.alibaba.dubbo.config.annotation.Reference
	private IDemoDubboService demoDubboService;
	
	@Override
	public String sayHello(String name) {
		return demoDubboService.sayHello(name);
	}

}
