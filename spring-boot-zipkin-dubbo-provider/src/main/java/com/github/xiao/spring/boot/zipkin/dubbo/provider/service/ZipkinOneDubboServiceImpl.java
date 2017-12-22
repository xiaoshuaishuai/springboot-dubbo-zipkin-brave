package com.github.xiao.spring.boot.zipkin.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.xiao.spring.boot.zipkin.dubbo.api.dubboservice.IZipkinOneDubboService;
import com.github.xiao.spring.boot.zipkin.dubbo.api.dubboservice.IZipkinThreeDubboService;
import com.github.xiao.spring.boot.zipkin.dubbo.api.dubboservice.IZipkinTwoDubboService;

@Service // (timeout = 5000)
public class ZipkinOneDubboServiceImpl implements IZipkinOneDubboService {

	@com.alibaba.dubbo.config.annotation.Reference(check = false)
	private IZipkinTwoDubboService zipkinTwoDubboService;

	@com.alibaba.dubbo.config.annotation.Reference(check = false)
	private IZipkinThreeDubboService zipkinThreeDubboService;

	@Override
	public String h1(String hello) {
		return "[" + zipkinTwoDubboService.h2(hello) + zipkinThreeDubboService.h3(hello) + "]";
	}

}
