package com.github.xiao.spring.boot.zipkin.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.xiao.spring.boot.zipkin.dubbo.api.dubboservice.IDemoDubboService;

@Service(timeout = 5000)
public class DemoDubboServiceImpl implements IDemoDubboService {

	public String sayHello(String name) {
		return "Hello " + name;
	}
}
