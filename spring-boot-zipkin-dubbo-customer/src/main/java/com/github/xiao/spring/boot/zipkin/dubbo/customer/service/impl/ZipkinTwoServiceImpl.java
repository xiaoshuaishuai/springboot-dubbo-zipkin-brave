package com.github.xiao.spring.boot.zipkin.dubbo.customer.service.impl;

import org.springframework.stereotype.Service;

import com.github.xiao.spring.boot.zipkin.dubbo.api.dubboservice.IZipkinTwoDubboService;
import com.github.xiao.spring.boot.zipkin.dubbo.customer.service.IZipkinTwoService;

@Service
public class ZipkinTwoServiceImpl implements IZipkinTwoService {

	@com.alibaba.dubbo.config.annotation.Reference(check = false)
	private IZipkinTwoDubboService zipkinTwoDubboService;

	@Override
	public String h2(String hello) {
		return zipkinTwoDubboService.h2(hello);
	}

}
