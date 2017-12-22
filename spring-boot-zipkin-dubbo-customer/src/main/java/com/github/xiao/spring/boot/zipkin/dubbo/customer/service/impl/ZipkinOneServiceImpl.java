package com.github.xiao.spring.boot.zipkin.dubbo.customer.service.impl;

import org.springframework.stereotype.Service;

import com.github.xiao.spring.boot.zipkin.dubbo.api.dubboservice.IZipkinOneDubboService;
import com.github.xiao.spring.boot.zipkin.dubbo.customer.service.IZipkinOneService;

@Service
public class ZipkinOneServiceImpl implements IZipkinOneService {

	@com.alibaba.dubbo.config.annotation.Reference(check = false)
	private IZipkinOneDubboService zipkinOneDubboService;

	@Override
	public String h1(String hello) {
		return zipkinOneDubboService.h1(hello);
	}

}
