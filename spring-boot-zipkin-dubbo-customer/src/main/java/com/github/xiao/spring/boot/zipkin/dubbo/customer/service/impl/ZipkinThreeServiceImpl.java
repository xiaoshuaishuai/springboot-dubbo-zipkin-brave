package com.github.xiao.spring.boot.zipkin.dubbo.customer.service.impl;

import org.springframework.stereotype.Service;

import com.github.xiao.spring.boot.zipkin.dubbo.api.dubboservice.IZipkinThreeDubboService;
import com.github.xiao.spring.boot.zipkin.dubbo.customer.service.IZipkinThreeService;

@Service
public class ZipkinThreeServiceImpl implements IZipkinThreeService {

	@com.alibaba.dubbo.config.annotation.Reference(check = false)
	private IZipkinThreeDubboService zipkinThreeDubboService;

	@Override
	public String h3(String hello) {
		return zipkinThreeDubboService.h3(hello);
	}

}
