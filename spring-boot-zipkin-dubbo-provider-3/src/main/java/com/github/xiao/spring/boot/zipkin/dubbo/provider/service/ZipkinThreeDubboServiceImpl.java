package com.github.xiao.spring.boot.zipkin.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.xiao.spring.boot.zipkin.dubbo.api.dubboservice.IZipkinThreeDubboService;

@Service//(timeout = 5000)
public class ZipkinThreeDubboServiceImpl implements IZipkinThreeDubboService {
	@Override
	public String h3(String hello) {
		return "服务33333333333333333333333";
	}
}
